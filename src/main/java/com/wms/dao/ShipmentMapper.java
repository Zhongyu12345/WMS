package com.wms.dao;

import com.wms.bean.Shipment;

public interface ShipmentMapper {
    int deleteByPrimaryKey(Integer shId);

    int insert(Shipment record);

    int insertSelective(Shipment record);

    Shipment selectByPrimaryKey(Integer shId);

    int updateByPrimaryKeySelective(Shipment record);

    int updateByPrimaryKey(Shipment record);
}