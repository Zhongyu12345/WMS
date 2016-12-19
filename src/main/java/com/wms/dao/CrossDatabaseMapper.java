package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.CrossDatabase;

@Repository
public interface CrossDatabaseMapper {
    int deleteByPrimaryKey(Integer cdId);

    int insert(CrossDatabase record);

    int insertSelective(CrossDatabase record);

    CrossDatabase selectByPrimaryKey(Integer cdId);

    int updateByPrimaryKeySelective(CrossDatabase record);

    int updateByPrimaryKey(CrossDatabase record);
}