package com.wms.dao;

import com.wms.bean.StockRemoval;

public interface StockRemovalMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(StockRemoval record);

    int insertSelective(StockRemoval record);

    StockRemoval selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(StockRemoval record);

    int updateByPrimaryKey(StockRemoval record);
}