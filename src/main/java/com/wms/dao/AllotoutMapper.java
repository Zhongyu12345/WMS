package com.wms.dao;

import com.wms.bean.Allotout;

public interface AllotoutMapper {
    int deleteByPrimaryKey(Integer aoId);

    int insert(Allotout record);

    int insertSelective(Allotout record);

    Allotout selectByPrimaryKey(Integer aoId);

    int updateByPrimaryKeySelective(Allotout record);

    int updateByPrimaryKey(Allotout record);
}