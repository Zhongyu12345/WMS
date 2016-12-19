package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Receiving;

/**
 * receiving 实际入库表
 */
@Repository
public interface ReceivingMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Receiving record);

    int insertSelective(Receiving record);

    Receiving selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Receiving record);

    int updateByPrimaryKey(Receiving record);
}