package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.MakeInventory;

@Repository
public interface MakeInventoryMapper {
    int deleteByPrimaryKey(Integer miId);

    int insert(MakeInventory record);

    int insertSelective(MakeInventory record);

    MakeInventory selectByPrimaryKey(Integer miId);

    int updateByPrimaryKeySelective(MakeInventory record);

    int updateByPrimaryKey(MakeInventory record);
}