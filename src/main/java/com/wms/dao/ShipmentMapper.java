package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Shipment;


/**
 * shipment实际出库表
 */
@Repository
public interface ShipmentMapper {
    int deleteByPrimaryKey(Integer shId);

    int insert(Shipment record);

    int insertSelective(Shipment record);

    Shipment selectByPrimaryKey(Integer shId);

    int updateByPrimaryKeySelective(Shipment record);

    int updateByPrimaryKey(Shipment record);
}