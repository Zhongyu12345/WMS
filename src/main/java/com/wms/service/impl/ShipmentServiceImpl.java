package com.wms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Shipment;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.ShipmentMapper;
import com.wms.service.GodownService;
import com.wms.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/19.
 */
@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentMapper shipmentMapper;

    @Autowired
    private GodownService godownService;

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

    @SuppressWarnings("deprecation")
	@Transactional
    @Override
    public int addShipment(Shipment shipment) {
        //后台单号生成
        /*shipment.setShSippingno(OrderNumberUtil.generateOrderNo());*/
        //减库存操作
        //noinspection deprecation
        godownService.reduction(shipment.getShWhid(), shipment.getShTotalvolume());
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

    @SuppressWarnings("deprecation")
	@Transactional
    @Override
    public int importShipment(Shipment shipment) {
        //noinspection deprecation
        godownService.reduction(shipment.getShWhid(), shipment.getShTotalvolume());
        return shipmentMapper.insert(shipment);
    }

}
