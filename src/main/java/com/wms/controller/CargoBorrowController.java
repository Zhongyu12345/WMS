package com.wms.controller;

import com.wms.bean.CargoBorrow;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.CargoBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @RequestMapping
    public Object select(CargoBorrow cargoBorrow,Integer page, Integer rows){
        PageInfo pageInfo = new PageInfo(page,rows);
        Map<String,Object> map = new HashMap<String,Object>();

        pageInfo.setCondition(map);
        cargoborrowservice.select(pageInfo);
        return pageInfo;
    }
}
