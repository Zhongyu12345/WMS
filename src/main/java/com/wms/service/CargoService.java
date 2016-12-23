package com.wms.service;

import com.wms.bean.Cargo;

public interface CargoService {
	 	int deleteByPrimaryKey(Integer cId);

	    int insert(Cargo record);

	    int insertSelective(Cargo record);

	    Cargo selectByPrimaryKey(Integer cId);

	    int updateByPrimaryKeySelective(Cargo record);

	    int updateByPrimaryKey(Cargo record);
}
