package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Adjust;

@Repository
public interface AdjustMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Adjust record);

    int insertSelective(Adjust record);

    Adjust selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(Adjust record);

    int updateByPrimaryKey(Adjust record);
}