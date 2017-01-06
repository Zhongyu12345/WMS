package com.wms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.GodownEntry;

@Repository
public interface GodownEntryMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(GodownEntry record);

    int insertSelective(GodownEntry record);

    GodownEntry selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GodownEntry record);

    int updateByPrimaryKey(GodownEntry record);
    
    GodownEntry selectByNo(String No);
    
    List<GodownEntry> selectAll(Pagination page, Map<String, Object> params);
}