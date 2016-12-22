package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Notice;

@Repository
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Notice notice);

    int insertSelective(Notice notice);

    Notice selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Notice notice);

    int updateByPrimaryKey(Notice notice);
}