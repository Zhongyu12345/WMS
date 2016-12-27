package com.wms.controller;

import com.wms.bean.GiveBack;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.GiveBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * 货品归还登记
 * Created by DengMin on 2016/12/23.
 */
@Controller
@RequestMapping("/giveback")
public class GiveBackController extends BaseController{

    @Autowired
    private GiveBackService giveBackService;

    /**
     * @return
     */
    @GetMapping("/givepage")
    public String geivpage(){
        return "adjustment/giveback";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deletepk")
    @ResponseBody
    public Object deleteByPrimaryKey(Integer id){
        int result = giveBackService.deleteByPrimaryKey(id);
        if(result > 0){
            return renderSuccess("删除成功");
        }
        return renderError("删除失败");
    }

    /**
     * 新增
     * @param giveBack
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(GiveBack giveBack){
        int result = giveBackService.insert(giveBack);
        if(result > 0){
            return renderSuccess("添加成功");
        }
        return renderError("添加失败");
    }

    /**
     * 修改
     * @param giveBack
     * @return
     */
    @RequestMapping("/updatepk")
    @ResponseBody
    public Object updateByPrimaryKeySelective(GiveBack giveBack){
        int result = giveBackService.updateByPrimaryKeySelective(giveBack);
        if(result > 0 ){
            return renderSuccess("修改成功");
        }
        return renderError("修改失败");
    }

    /**
     * 分页查询
     * @param giveBack
     * @param rows
     * @param page
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public Object select(GiveBack giveBack ,Integer rows,Integer page){
        PageInfo pageInfo = new PageInfo();
        Map<String,Object> map = new HashMap<>();
        if(giveBack.getCreatedateStart() != null){
            map.put("startTime",giveBack.getCreatedateStart());
        }
        if(giveBack.getCreatedateEnd() != null){
            map.put("endTime",giveBack.getCreatedateEnd());
        }
        if(giveBack.getGbSkumodel() != null){
            map.put("gbSK",giveBack.getGbSkumodel());
        }
        pageInfo.setCondition(map);
        giveBackService.select(pageInfo);
        return pageInfo;
    }
}
