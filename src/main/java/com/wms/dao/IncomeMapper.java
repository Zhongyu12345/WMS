package com.wms.dao;


import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Income;
import com.wms.bean.vo.IncomeVo;

public interface IncomeMapper {
	
    int deleteByPrimaryKey(Integer iid);

    int insert(Income record);

    int insertSelective(Income record);

    Income selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
    
    IncomeVo selectByTime(String Timeyears);
    
    List<Income> selectDataGrid(Pagination page, Map<String, Object> params);
}