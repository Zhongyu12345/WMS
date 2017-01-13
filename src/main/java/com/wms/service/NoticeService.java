package com.wms.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Notice;
import com.wms.commons.utils.PageInfo;

public interface NoticeService {
    int deleteByPrimaryKey(Integer jId);

    int insert(Notice notice);

    int insertSelective(Notice notice);

    Notice selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Notice notice);

    int updateByPrimaryKey(Notice notice);

    void selectDataGrid(PageInfo pageInfo);

    Notice selectByDateUP();
}
