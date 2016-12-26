package com.wms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Shipment;
import com.wms.commons.utils.OrderNumberUtil;
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
    public Shipment selectById(Integer id) {
        return shipmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addShipment(Shipment shipment) {
        shipment.setShSippingno(OrderNumberUtil.generateOrderNo());
        return shipmentMapper.insert(shipment);
    }

    @Override
    public int deleteById(Integer id) {
        Shipment shipment = selectById(id);
        if (shipment != null) {
            return shipmentMapper.deleteByPrimaryKey(id);
        } else {
            //没有此ID
            return 0;
        }
    }

    /**
     * Selective 为动态SQL
     *
     * @param shipment
     * @return
     */
    @Override
    public int updateShipment(Shipment shipment) {
        return shipmentMapper.updateByPrimaryKeySelective(shipment);
    }

}
