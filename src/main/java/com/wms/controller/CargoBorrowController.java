package com.wms.controller;

import com.wms.bean.CargoBorrow;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.CargoBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DengMin on 2016/12/21.
 */
@Controller
@RequestMapping("/borrow")
public class CargoBorrowController extends BaseController{

    @Autowired
    private CargoBorrowService cargoborrowservice;

    /**
     * 跳转到cargoborrow页面
     * @return
     */
    @GetMapping("/borrowpage")
    public String borrowpage(){
        return "adjustment/cargoborrow";
    }

    /**
     * 跳转到cargoborrowadd页面
     * @return
     */
    @GetMapping("/borrowaddpage")
    public String borrowaddpage(){
        return "adjustment/cargoborrowadd";
    }

    /**
     * 新增货品借出
     * @param cargoBorrow
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(CargoBorrow cargoBorrow){
        int result = cargoborrowservice.insert(cargoBorrow);
        if(result > 0){
            return renderSuccess("添加成功");
        }
        return renderError("添加失败");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object deleteByPrimaryKey(Integer id){
        int result = cargoborrowservice.deleteByPrimaryKey(id);
        if(result > 0){
            return renderSuccess("删除成功");
        }
        return  renderError("删除失败");
    }

    /**
     * 分页查询
     * @param cargoBorrow
     * @param page
     * @param rows
     * @return
     */
    @PostMapping("/selectByPage")
    @ResponseBody
    public Object select(CargoBorrow cargoBorrow,Integer page, Integer rows){
        PageInfo pageInfo = new PageInfo(page,rows);
        Map<String,Object> map = new HashMap<String,Object>();
        if(cargoBorrow.getCbSkumodel() != null){
            map.put("CBSK",cargoBorrow.getCbSkumodel());
        }
        if(cargoBorrow.getCreatedateStart() != null){
            map.put("startTime",cargoBorrow.getCreatedateStart());
        }
        if(cargoBorrow.getCreatedateEnd() != null){
            map.put("endTime",cargoBorrow.getCreatedateEnd());
        }
        pageInfo.setCondition(map);
        cargoborrowservice.select(pageInfo);
        return pageInfo;
    }
}
