package com.wms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Shipment;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.ShipmentMapper;
import com.wms.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/19.
 */
@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentMapper shipmentMapper;

    @Override
    public List<Shipment> queryAll() {
        return shipmentMapper.queryAll();
    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<Shipment> page = new Page<Shipment>(pageInfo.getNowpage(), pageInfo.getSize());
        List<Shipment> list = shipmentMapper.selectShipmentPage(page, pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public int addShipment(Shipment shipment) {
        return shipmentMapper.insert(shipment);
    }

}
