package com.wms.controller;

import com.wms.bean.Shipment;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实际出库表
 * Created by ZhongYu on 2016/12/19.
 */
@Controller
@RequestMapping(value = "shipment")
public class ShipmentController extends BaseController {

    @Autowired
    private ShipmentService shipmentService;

    /**
     * @return 出货单管理页面
     */
    @GetMapping(value = "shipment.html")
    public String getShipmentPage() {
        return "outbound/shipment";
    }

    /**
     * 分页查询
     *
     * @param shipment
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @ResponseBody
    @PostMapping("dataGrid")
    public Object dataGrid(Shipment shipment, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        pageInfo.setCondition(condition);
        shipmentService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    /**
     * 查询所有实际出库表
     */
    @ResponseBody
    @GetMapping(value = "shipment")
    public List<Shipment> queryAll() {
        return shipmentService.queryAll();
    }

    @GetMapping("shipmentAdd")
    public String getAddShipmentPage() {
        return "outbound/shipmentAdd";
    }

    /**
     * 添加操作
     *
     * @param shipment 提交内容
     * @param addtime  添加时间
     * @return
     */
    @ResponseBody
    @PostMapping(value = "shipment")
    public Object addShipment(Shipment shipment, String addtime) {
        shipment.setShTime(updateTime(addtime));
        int result = shipmentService.addShipment(shipment);
        if (result > 0) {
            return renderSuccess("添加成功!");
        } else {
            return renderError("添加失败!");
        }
    }

    /**
     * 删除操作
     *
     * @param id 编号
     * @return
     */
    @ResponseBody
    @PostMapping(value = "shipment/delete")
    public Object deleteById(Integer id) {
        int result = shipmentService.deleteById(id);
        if (result > 0) {
            return renderSuccess("删除成功!");
        } else {
            return renderError("删除失败!");
        }
    }

    /**
     * 进入编辑页面
     *
     * @return
     */
    @GetMapping(value = "getEditPage")
    public String editPage(Model model, @RequestParam(value = "id") Integer id) {
        logger.info("进入编辑页面...");
        Shipment shipment = shipmentService.selectById(id);
        model.addAttribute("shipment", shipment);
        return "outbound/shipmentEdit";
    }

    /**
     * 更新操作
     *
     * @param shipment
     * @param addtime
     * @return
     */
    @ResponseBody
    @PostMapping(value = "shipment/update")
    public Object updateShipment(Shipment shipment, String addtime) {
        shipment.setShTime(updateTime(addtime));
        int result = shipmentService.updateShipment(shipment);
        if (result > 0) {
            return renderSuccess("更新成功!");
        } else {
            return renderError("更新失败!");
        }
    }

    /**
     * 把字符串时间转成Date类型
     *
     * @param time
     * @return
     */
    public Date updateTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
