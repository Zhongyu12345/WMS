package com.wms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Adjust;

@Repository
public interface AdjustMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Adjust record);

    int insertSelective(Adjust record);

    List<Adjust> selectByPrimaryKey(Integer jId);

    List<Adjust> select(Pagination page,Map<String,Object> map);

    int updateByPrimaryKeySelective(Adjust record);

    int updateByPrimaryKey(Adjust record);
}