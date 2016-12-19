package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.GiveBack;

/**
 * give_back 货品归还表
 */
@Repository
public interface GiveBackMapper {
    int deleteByPrimaryKey(Integer gbId);

    int insert(GiveBack record);

    int insertSelective(GiveBack record);

    GiveBack selectByPrimaryKey(Integer gbId);

    int updateByPrimaryKeySelective(GiveBack record);

    int updateByPrimaryKey(GiveBack record);
}