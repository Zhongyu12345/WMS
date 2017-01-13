package com.wms.service;


import com.wms.bean.Income;
import com.wms.bean.vo.IncomeVo;
import com.wms.commons.utils.PageInfo;

public interface IncomeService {
	int deleteByPrimaryKey(Integer iid);

    int insert(Income record);

    int insertSelective(Income record);

    Income selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
    
    IncomeVo selectByTime(String Timeyears);
    
    void selectDataGrid(PageInfo pageInfo);
}
