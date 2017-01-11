package com.wms.service;

import com.wms.bean.Cargo;
import com.wms.commons.utils.PageInfo;

public interface CargoService {
	 	int deleteByPrimaryKey(Integer cId);

	    int insert(Cargo record);

	    int insertSelective(Cargo record);

	    Cargo selectByPrimaryKey(Integer cId);

	   void select(PageInfo pageInfo);

	    int updateByPrimaryKeySelective(Cargo record);

	    int updateByPrimaryKey(Cargo record);

	    int update(Cargo cargo);

		int updatenum(Cargo cargo);
		
		Cargo selectBySkumodel(String Skumodel);
}
