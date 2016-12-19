package com.wms.controller;

import com.wms.bean.Shipment;
import com.wms.commons.utils.PageInfo;
import com.wms.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class ShipmentController {

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

    /**
     * 添加操作
     *
     * @param shipment 添加地址
     * @param addtime  添加时间
     * @return
     */
    @ResponseBody
    @PostMapping(value = "shipment")
    public int addShipment(Shipment shipment, String addtime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (null != addtime) {
            try {
                Date date = format.parse(addtime);
                shipment.setShTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println(shipment);
        return shipmentService.addShipment(shipment);
    }

}
