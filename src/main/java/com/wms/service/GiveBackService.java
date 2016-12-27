package com.wms.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.GiveBack;
import com.wms.commons.utils.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by DengMin on 2016/12/23.
 */
public interface GiveBackService {
    int deleteByPrimaryKey(Integer gbId);

    int insert(GiveBack record);

    int insertSelective(GiveBack record);

    GiveBack selectByPrimaryKey(Integer gbId);

    void select(PageInfo pageInfo);

    int updateByPrimaryKeySelective(GiveBack record);

    int updateByPrimaryKey(GiveBack record);
}
