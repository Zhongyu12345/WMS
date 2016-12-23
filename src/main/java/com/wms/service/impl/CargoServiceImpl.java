package com.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.bean.Cargo;
import com.wms.dao.CargoMapper;
import com.wms.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoMapper cargoMapper;

	@Override
	public int deleteByPrimaryKey(Integer cId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Cargo record) {
		return cargoMapper.insert(record);
	}

	@Override
	public int insertSelective(Cargo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cargo selectByPrimaryKey(Integer cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Cargo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Cargo record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
