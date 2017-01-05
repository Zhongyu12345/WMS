package com.wms.service;

import java.util.List;

import com.wms.bean.MakeInventory;
import com.wms.commons.utils.PageInfo;

/**
 * Created by DengMin on 2016/12/23.
 */
public interface MakeInventoryService {
    int deleteByPrimaryKey(Integer miId);

    int insert(MakeInventory record);

    int insertSelective(MakeInventory record);

    MakeInventory selectByPrimaryKey(Integer miId);

    void select(PageInfo pageInfo);

    int updateByPrimaryKeySelective(MakeInventory record);

    int updateByPrimaryKey(MakeInventory record);
    
    List<MakeInventory> selectByOrder(String order);
}
