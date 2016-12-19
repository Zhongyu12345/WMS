package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Income;

/**
 * income 收/入财务表
 */
@Repository
public interface IncomeMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Income record);

    int insertSelective(Income record);

    Income selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
}