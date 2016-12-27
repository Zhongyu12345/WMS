package com.wms.dao;

import com.wms.bean.Compay;

public interface CompayMapper {
    int deleteByPrimaryKey(Integer caid);

    int insert(Compay record);

    int insertSelective(Compay record);

    Compay selectByPrimaryKey(Integer caid);

    int updateByPrimaryKeySelective(Compay record);

    int updateByPrimaryKey(Compay record);
}