package com.wms.service;

import com.wms.bean.Allotput;
import com.wms.commons.utils.PageInfo;

public interface AllotputService {

    int deleteByPrimaryKey(Integer apId);

    int insert(Allotput record);

    int insertSelective(Allotput record);

    Allotput selectByPrimaryKey(Integer apId);
    
    void selectAll(PageInfo pageinfo);

    int updateByPrimaryKeySelective(Allotput record);

    int updateByPrimaryKey(Allotput record);
}
