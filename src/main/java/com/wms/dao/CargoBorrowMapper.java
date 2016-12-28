package com.wms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.CargoBorrow;

@Repository
public interface CargoBorrowMapper {
    int deleteByPrimaryKey(Integer cbId);

    int insert(CargoBorrow record);

    int insertSelective(CargoBorrow record);

    CargoBorrow selectByPrimaryKey(Integer cbId);

    List<CargoBorrow> select(Pagination page, Map<String,Object> map);

    int updateByPrimaryKeySelective(CargoBorrow record);

    int updateByPrimaryKey(CargoBorrow record);
}