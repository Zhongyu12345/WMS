package com.wms.service;

import com.wms.bean.CargoBorrow;
import com.wms.commons.utils.PageInfo;

/**
 * Created by DengMin on 2016/12/21.
 */
public interface CargoBorrowService {
    int deleteByPrimaryKey(Integer cbId);

    int insert(CargoBorrow record);

    int insertSelective(CargoBorrow record);

    CargoBorrow selectByPrimaryKey(Integer cbId);

    void select(PageInfo pageInfo);

    int updateByPrimaryKeySelective(CargoBorrow record);

    int updateByPrimaryKey(CargoBorrow record);
}
