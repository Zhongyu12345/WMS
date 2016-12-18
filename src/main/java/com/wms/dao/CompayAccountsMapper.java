package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.CompayAccounts;

@Repository
public interface CompayAccountsMapper {
    int deleteByPrimaryKey(Integer caId);

    int insert(CompayAccounts record);

    int insertSelective(CompayAccounts record);

    CompayAccounts selectByPrimaryKey(Integer caId);

    int updateByPrimaryKeySelective(CompayAccounts record);

    int updateByPrimaryKey(CompayAccounts record);
}