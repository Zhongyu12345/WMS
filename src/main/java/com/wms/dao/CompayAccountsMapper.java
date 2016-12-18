package com.wms.dao;

import com.wms.bean.CompayAccounts;

public interface CompayAccountsMapper {
    int deleteByPrimaryKey(Integer caId);

    int insert(CompayAccounts record);

    int insertSelective(CompayAccounts record);

    CompayAccounts selectByPrimaryKey(Integer caId);

    int updateByPrimaryKeySelective(CompayAccounts record);

    int updateByPrimaryKey(CompayAccounts record);
}