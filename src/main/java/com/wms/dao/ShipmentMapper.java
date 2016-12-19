package com.wms.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.stereotype.Repository;

import com.wms.bean.Shipment;

import java.util.List;
import java.util.Map;

/**
 * shipment实际出库表
 */
@Repository
public interface ShipmentMapper {

    /**
     * 查询所有
     */
    List<Shipment> queryAll();

    /**
     * 分页查询
     */
    List<Shipment> selectShipmentPage(Pagination page, Map<String, Object> params);

    int deleteByPrimaryKey(Integer shId);

    int insert(Shipment record);

    int insertSelective(Shipment record);

    Shipment selectByPrimaryKey(Integer shId);

    int updateByPrimaryKeySelective(Shipment record);

    int updateByPrimaryKey(Shipment record);
}