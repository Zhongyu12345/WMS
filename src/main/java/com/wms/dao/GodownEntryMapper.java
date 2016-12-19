package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.GodownEntry;

/**
 * godown_entry入库计划单
 */
@Repository
public interface GodownEntryMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(GodownEntry record);

    int insertSelective(GodownEntry record);

    GodownEntry selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GodownEntry record);

    int updateByPrimaryKey(GodownEntry record);
}