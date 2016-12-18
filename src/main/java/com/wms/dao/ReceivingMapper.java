package com.wms.dao;

import com.wms.bean.Receiving;

public interface ReceivingMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Receiving record);

    int insertSelective(Receiving record);

    Receiving selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Receiving record);

    int updateByPrimaryKey(Receiving record);
}