package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Cargo;

@Repository
public interface CargoMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Cargo record);

    int insertSelective(Cargo record);

    Cargo selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Cargo record);

    int updateByPrimaryKey(Cargo record);
}