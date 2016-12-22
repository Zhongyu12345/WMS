package com.wms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Allotput;

@Repository
public interface AllotputMapper {
    int deleteByPrimaryKey(Integer apId);

    int insert(Allotput record);

    int insertSelective(Allotput record);

    Allotput selectByPrimaryKey(Integer apId);
    
    List<Allotput>selectAll(Pagination page, Map<String, Object> params);

    int updateByPrimaryKeySelective(Allotput record);

    int updateByPrimaryKey(Allotput record);
}