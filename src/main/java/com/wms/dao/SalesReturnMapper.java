package com.wms.dao;

import com.wms.bean.SalesReturn;

public interface SalesReturnMapper {
    int deleteByPrimaryKey(Integer srId);

    int insert(SalesReturn record);

    int insertSelective(SalesReturn record);

    SalesReturn selectByPrimaryKey(Integer srId);

    int updateByPrimaryKeySelective(SalesReturn record);

    int updateByPrimaryKey(SalesReturn record);
}