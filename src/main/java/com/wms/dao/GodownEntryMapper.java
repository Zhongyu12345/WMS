package com.wms.dao;

import com.wms.bean.GodownEntry;

public interface GodownEntryMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(GodownEntry record);

    int insertSelective(GodownEntry record);

    GodownEntry selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GodownEntry record);

    int updateByPrimaryKey(GodownEntry record);
}