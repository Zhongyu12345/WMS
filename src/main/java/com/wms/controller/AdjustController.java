package com.wms.controller;

import com.wms.bean.Adjust;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.ExcelToDisk;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.ReadXls;
import com.wms.service.AdjustService;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存调整单查询
 * Created by DengMin on 2016/12/20.
 */

@Controller
@RequestMapping("/adjust")
public class AdjustController extends BaseController{

    @Autowired
    private AdjustService adjustService;

    /**
     *跳转到adjust页面
     * @return
     */
    @GetMapping("/page")
    public String page(){
        return "adjustment/adjust";
    }

    /**
     *分页查询
     * @param page
     * @param rows
     */
    @PostMapping("/select")
    @ResponseBody
    public Object select(Adjust adjust,Integer page,Integer rows){
        PageInfo pageinfo = new PageInfo(page,rows);
        Map<String,Object> map = new HashMap<String,Object>();
        if(adjust.getjSkumodel() != null){
            map.put("num",adjust.getjSkumodel());
        }
        if(adjust.getCreatedateStart() != null){
            map.put("startTime",adjust.getCreatedateStart());
        }
        if(adjust.getCreatedateEnd() != null){
            map.put("endTime",adjust.getCreatedateEnd());
        }
        pageinfo.setCondition(map);
        adjustService.select(pageinfo);
        return pageinfo;
    }

    /**
     *删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Integer id){
        int result = adjustService.deleteByPrimaryKey(id);
        if(result > 0){
            return renderSuccess("删除成功");
        }
        return renderError("删除失败");
    }
}
