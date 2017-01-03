package com.wms.dao;

import java.util.List;
<<<<<<< Updated upstream
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
=======

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.Page;
>>>>>>> Stashed changes
import com.wms.bean.Allotput;

@Repository
public interface AllotputMapper {
    int deleteByPrimaryKey(Integer apId);

    int insert(Allotput record);

    int insertSelective(Allotput record);

<<<<<<< Updated upstream
    Allotput selectByPrimaryKey(Integer apId);
    
    List<Allotput>selectAll(Pagination page, Map<String, Object> params);
=======
    List<Allotput> selectByPrimaryKey(Integer apId);
    
    List<Allotput>selectAll(Page<Allotput> page);
>>>>>>> Stashed changes

    int updateByPrimaryKeySelective(Allotput record);

    int updateByPrimaryKey(Allotput record);
}