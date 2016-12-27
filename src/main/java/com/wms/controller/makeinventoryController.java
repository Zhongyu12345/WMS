package com.wms.controller;

import com.wms.bean.MakeInventory;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.MakeInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * 盘点单管理
 * Created by DengMin on 2016/12/23.
 */

@Controller
@RequestMapping("/make")
public class makeinventoryController extends BaseController{

    @Autowired
    private MakeInventoryService makeInventoryService;

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deletepk")
    @ResponseBody
    public Object deleteByPrimaryKey(Integer id){
        int result = makeInventoryService.deleteByPrimaryKey(id);
        if(result > 0){
            return renderSuccess("删除成功");
        }
        return renderError("删除失败");
    }

    /**
     * 新增
     * @param m
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(MakeInventory m){
        int result = makeInventoryService.insert(m);
        if(result  > 0){
            return renderSuccess("添加成功");
        }
        return renderError("添加失败");
    }

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param m
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public Object select(Integer page,Integer rows,MakeInventory m){
        PageInfo pageInfo = new PageInfo();
        Map<String,Object> map = new HashMap<>();
        if(m.getMiSkumodel() != null){
            map.put("SKM",m.getMiSkumodel());
        }
        if(m.getCreateState() != null){
            map.put("stateTime",m.getCreateState());
        }
        if(m.getCreateEnd() != null){
            map.put("endTime",m.getCreateEnd());
        }
        pageInfo.setCondition(map);
        makeInventoryService.select(pageInfo);
        return pageInfo;
    }

}
