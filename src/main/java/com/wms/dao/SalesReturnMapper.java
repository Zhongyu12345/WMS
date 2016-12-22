package com.wms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.SalesReturn;

@Repository
public interface SalesReturnMapper {
    int deleteByPrimaryKey(Integer srId);

    int insert(SalesReturn record);

    int insertSelective(SalesReturn record);

    SalesReturn selectByPrimaryKey(Integer srId);
    
    List<SalesReturn> selectAll(Pagination page, Map<String, Object> params);

    int updateByPrimaryKeySelective(SalesReturn record);

    int updateByPrimaryKey(SalesReturn record);
}