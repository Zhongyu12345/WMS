package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Allotput;

/**
 * allotput 调拨入库表
 */
@Repository
public interface AllotputMapper {
    int deleteByPrimaryKey(Integer apId);

    int insert(Allotput record);

    int insertSelective(Allotput record);

    Allotput selectByPrimaryKey(Integer apId);

    int updateByPrimaryKeySelective(Allotput record);

    int updateByPrimaryKey(Allotput record);
}