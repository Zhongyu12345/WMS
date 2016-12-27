package com.wms.controller;

import com.wms.bean.CrossDatabase;
import com.wms.commons.base.BaseController;
import com.wms.commons.bean.Search;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.StringUtils;
import com.wms.commons.utils.TimeUtils;
import com.wms.service.CrossDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 越库出货单
 * Created by ZhongYu on 2016/12/23.
 */
@Controller
@RequestMapping(value = "crossDatabase")
public class CrossDatabaseController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(CrossDatabaseController.class);

    @Autowired
    private CrossDatabaseService crossDatabaseService;

    /** 出货单管理页面 */
    @GetMapping(value = "crossDatabase.html")
    public String getShipmentPage() {
        return "outbound/crossDatabase";
    }

    /** 分页查询 */
    @ResponseBody
    @PostMapping("dataGrid")
    public Object dataGrid(Search search, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(search.getName())) {
            logger.getName();
            condition.put("name", search.getName());
        }
        if (search.getStartTime() != null) {
            condition.put("startTime", search.getStartTime());
        }
        if (search.getEndTime() != null) {
            condition.put("endTime", search.getEndTime());
        }
        pageInfo.setCondition(condition);
        crossDatabaseService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    /** 查询所有实际出库表 */
    @ResponseBody
    @GetMapping(value = "crossDatabase")
    public List<CrossDatabase> queryAll() {
        return crossDatabaseService.queryAll();
    }

    @GetMapping("crossDatabase/insert")
    public String getAddShipmentPage() {
        return "outbound/crossDatabaseAdd";
    }

    /** 添加操作 */
    @ResponseBody
    @PostMapping(value = "crossDatabase")
    public Object addShipment(CrossDatabase crossDatabase, String byTime) {
        crossDatabase.setCdTime(TimeUtils.updateTime(byTime));
        int result = crossDatabaseService.addCrossDatabase(crossDatabase);
        if (result > 0) {
            return renderSuccess("添加成功!");
        } else {
            return renderError("添加失败!");
        }
    }

    /** 删除操作 */
    @ResponseBody
    @PostMapping(value = "crossDatabase/delete")
    public Object deleteById(Integer id) {
        int result = crossDatabaseService.deleteById(id);
        if (result > 0) {
            return renderSuccess("删除成功!");
        } else {
            return renderError("删除失败!");
        }
    }

    /** 进入编辑页面 */
    @GetMapping(value = "getEditPage")
    public String editPage(Model model, @RequestParam(value = "id") Integer id) {
        CrossDatabase crossDatabase = crossDatabaseService.selectById(id);
        model.addAttribute("crossDatabase", crossDatabase);
        return "outbound/crossDatabaseEdit";
    }

    /** 更新操作 */
    @ResponseBody
    @PostMapping(value = "crossDatabase/update")
    public Object updateShipment(CrossDatabase crossDatabase, String byTime) {
        crossDatabase.setCdTime(TimeUtils.updateTime(byTime));
        int result = crossDatabaseService.updateCrossDatabase(crossDatabase);
        if (result > 0) {
            return renderSuccess("更新成功!");
        } else {
            return renderError("更新失败!");
        }
    }

}