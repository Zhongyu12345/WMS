package com.wms.dao;

import com.wms.bean.Allotput;

public interface AllotputMapper {
    int deleteByPrimaryKey(Integer apId);

    int insert(Allotput record);

    int insertSelective(Allotput record);

    Allotput selectByPrimaryKey(Integer apId);

    int updateByPrimaryKeySelective(Allotput record);

    int updateByPrimaryKey(Allotput record);
}