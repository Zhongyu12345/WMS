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
import com.wms.bean.SalesReturn;

@Repository
public interface SalesReturnMapper {
    int deleteByPrimaryKey(Integer srId);

    int insert(SalesReturn record);

    int insertSelective(SalesReturn record);

<<<<<<< Updated upstream
    SalesReturn selectByPrimaryKey(Integer srId);
    
    List<SalesReturn> selectAll(Pagination page, Map<String, Object> params);
=======
    List<SalesReturn> selectByPrimaryKey(Integer srId);
    
    List<SalesReturn> selectAll(Page<SalesReturn> page);
>>>>>>> Stashed changes

    int updateByPrimaryKeySelective(SalesReturn record);

    int updateByPrimaryKey(SalesReturn record);
}