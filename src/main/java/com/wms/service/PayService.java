package com.wms.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Pay;
import com.wms.bean.vo.IncomeVo;
import com.wms.commons.utils.PageInfo;

import java.util.List;
import java.util.Map;

public interface PayService {
	int deleteByPrimaryKey(Integer pid);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
    
    IncomeVo selectByTime(String time);

    void selectDataGrid(PageInfo pageInfo);
}
