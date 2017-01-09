package com.wms.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Tariff;

public interface TariffMapper {
	int deleteByPrimaryKey(Integer iid);

    int insert(Tariff tariff);

    int insertSelective(Tariff tariff);

    Tariff selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Tariff tariff);

    int updateByPrimaryKey(Tariff tariff);
    
    List<Tariff> selectDataGrid(Pagination page, Map<String, Object> params);
    
    List<Tariff> selectByCause ();
}
