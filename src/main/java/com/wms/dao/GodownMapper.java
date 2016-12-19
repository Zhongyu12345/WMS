package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Godown;

/**
 * godown 仓库表
 */
@Repository
public interface GodownMapper {
    int deleteByPrimaryKey(Integer goId);

    int insert(Godown record);

    int insertSelective(Godown record);

    Godown selectByPrimaryKey(Integer goId);

    int updateByPrimaryKeySelective(Godown record);

    int updateByPrimaryKey(Godown record);
}