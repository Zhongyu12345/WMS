package com.wms.dao;

import com.wms.bean.CrossDatabase;

public interface CrossDatabaseMapper {
    int deleteByPrimaryKey(Integer cdId);

    int insert(CrossDatabase record);

    int insertSelective(CrossDatabase record);

    CrossDatabase selectByPrimaryKey(Integer cdId);

    int updateByPrimaryKeySelective(CrossDatabase record);

    int updateByPrimaryKey(CrossDatabase record);
}