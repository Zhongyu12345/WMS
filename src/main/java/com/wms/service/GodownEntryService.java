package com.wms.service;

import com.wms.bean.GodownEntry;

public interface GodownEntryService  {
	int deleteByPrimaryKey(Integer gId);

    int insert(GodownEntry record);

    int insertSelective(GodownEntry record);

    GodownEntry selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GodownEntry record);

    int updateByPrimaryKey(GodownEntry record);
    
    GodownEntry selectByNo(String No);
}
