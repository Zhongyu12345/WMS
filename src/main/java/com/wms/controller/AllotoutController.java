package com.wms.controller;

import com.wms.bean.Allotout;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.AllotoutService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 调拨单管理
 * Created by ZhongYu on 2016/12/21.
 */
@Controller
@RequestMapping(value = "allotout")
public class AllotoutController extends BaseController {

    @Autowired
    private AllotoutService allotoutService;

    @GetMapping(value = "allotout.html")
    public String getAllotoutPage() {
        return "outbound/allotout";
    }

    @ResponseBody
    @PostMapping("dataGrid")
    public Object dataGrid(Allotout allotout, Integer page, Integer rows, String sort, String order) {
        //TODO:此处待搜索查询
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        pageInfo.setCondition(condition);
        allotoutService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    /**
     * 添加调拨单
     *
     * @param allotout
     * @return
     */
    @ResponseBody
    @PostMapping(value = "allotout")
    public Object addAllotout(Allotout allotout) {
        int result = allotoutService.addAllotout(allotout);
        if (result > 0) {
            return renderSuccess("添加成功!");
        } else {
            return renderError("添加失败!");
        }
    }

    @ResponseBody
    @PostMapping("allotout/delete")
    public Object deleteAllotout(@Param("id") Integer id) {
        int result = allotoutService.deleteAllotout(id);
        if (result > 0) {
            return renderSuccess("删除成功!");
        } else {
            return renderError("删除失败!");
        }
    }

}
