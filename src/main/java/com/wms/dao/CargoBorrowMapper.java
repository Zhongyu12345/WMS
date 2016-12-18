package com.wms.dao;

import com.wms.bean.CargoBorrow;

public interface CargoBorrowMapper {
    int deleteByPrimaryKey(Integer cbId);

    int insert(CargoBorrow record);

    int insertSelective(CargoBorrow record);

    CargoBorrow selectByPrimaryKey(Integer cbId);

    int updateByPrimaryKeySelective(CargoBorrow record);

    int updateByPrimaryKey(CargoBorrow record);
}