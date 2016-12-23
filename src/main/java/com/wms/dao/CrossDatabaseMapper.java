package com.wms.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.CrossDatabase;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/** */
@Repository
public interface CrossDatabaseMapper {

    /** 查询所有 */
    List<CrossDatabase> queryAll();

    /** 分页查询 */
    List<CrossDatabase> selectCrossDatabasePage(Pagination page, Map<String, Object> params);

    int deleteByPrimaryKey(Integer cdId);

    int insert(CrossDatabase record);

    int insertSelective(CrossDatabase record);

    CrossDatabase selectByPrimaryKey(Integer cdId);

    int updateByPrimaryKeySelective(CrossDatabase record);

    int updateByPrimaryKey(CrossDatabase record);
}