package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.GodownEntry;

@Repository
public interface GodownEntryMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(GodownEntry record);

    int insertSelective(GodownEntry record);

    GodownEntry selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GodownEntry record);

    int updateByPrimaryKey(GodownEntry record);
}