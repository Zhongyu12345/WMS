package com.wms.service;

import java.util.List;

import com.wms.bean.Adjust;
import com.wms.commons.utils.PageInfo;

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
