package com.wms.dao;

import com.wms.bean.Pay;

public interface PayMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
}