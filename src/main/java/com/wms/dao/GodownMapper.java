package com.wms.dao;

import com.wms.bean.Godown;

public interface GodownMapper {
    int deleteByPrimaryKey(Integer goId);

    int insert(Godown record);

    int insertSelective(Godown record);

    Godown selectByPrimaryKey(Integer goId);

    int updateByPrimaryKeySelective(Godown record);

    int updateByPrimaryKey(Godown record);
}