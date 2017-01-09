package com.wms.service;

import java.util.List;

import com.wms.bean.Tariff;
import com.wms.commons.utils.PageInfo;

public interface TariffService {
	int deleteByPrimaryKey(Integer iid);

    int insert(Tariff tariff);

    int insertSelective(Tariff tariff);

    Tariff selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Tariff tariff);

    int updateByPrimaryKey(Tariff tariff);
    
    void selectDataGrid(PageInfo pageInfo);
    
    List<Tariff> selectByCause();
}
