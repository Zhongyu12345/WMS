package com.wms.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.stereotype.Repository;

import com.wms.bean.Notice;

import java.util.List;
import java.util.Map;

@Repository
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Notice notice);

    int insertSelective(Notice notice);

    Notice selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Notice notice);

    int updateByPrimaryKey(Notice notice);

    List<Notice> selectDataGrid(Pagination page, Map<String, Object> params);

    Notice selectByDateUP();
}