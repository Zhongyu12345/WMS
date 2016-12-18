package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.StockRemoval;

@Repository
public interface StockRemovalMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(StockRemoval record);

    int insertSelective(StockRemoval record);

    StockRemoval selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(StockRemoval record);

    int updateByPrimaryKey(StockRemoval record);
}