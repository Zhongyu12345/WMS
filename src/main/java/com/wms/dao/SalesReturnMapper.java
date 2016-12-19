package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.SalesReturn;

/**
 * sales_return 退货入库表
 */
@Repository
public interface SalesReturnMapper {
    int deleteByPrimaryKey(Integer srId);

    int insert(SalesReturn record);

    int insertSelective(SalesReturn record);

    SalesReturn selectByPrimaryKey(Integer srId);

    int updateByPrimaryKeySelective(SalesReturn record);

    int updateByPrimaryKey(SalesReturn record);
}