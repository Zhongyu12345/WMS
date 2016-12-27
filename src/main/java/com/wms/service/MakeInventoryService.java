package com.wms.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.MakeInventory;
import com.wms.commons.utils.PageInfo;

import java.util.List;
import java.util.Map;

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
}
