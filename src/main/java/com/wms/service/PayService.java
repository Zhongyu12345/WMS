package com.wms.service;

import com.wms.bean.Pay;
import com.wms.bean.vo.IncomeVo;

public interface PayService {
	int deleteByPrimaryKey(Integer pid);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
    
    IncomeVo selectByTime(String time);
}
