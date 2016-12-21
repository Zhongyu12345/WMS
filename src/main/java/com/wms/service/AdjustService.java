package com.wms.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Adjust;
import com.wms.commons.utils.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by DengMin on 2016/12/20.
 */
public interface AdjustService {
    int deleteByPrimaryKey(Integer jId);

    int insert(Adjust record);

    int insertSelective(Adjust record);

    List<Adjust> selectByPrimaryKey(Integer jId);

    void select(PageInfo pageinfo);

    int updateByPrimaryKeySelective(Adjust record);

    int updateByPrimaryKey(Adjust record);
}
