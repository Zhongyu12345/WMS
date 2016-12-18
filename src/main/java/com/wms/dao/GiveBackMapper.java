package com.wms.dao;

import com.wms.bean.GiveBack;

public interface GiveBackMapper {
    int deleteByPrimaryKey(Integer gbId);

    int insert(GiveBack record);

    int insertSelective(GiveBack record);

    GiveBack selectByPrimaryKey(Integer gbId);

    int updateByPrimaryKeySelective(GiveBack record);

    int updateByPrimaryKey(GiveBack record);
}