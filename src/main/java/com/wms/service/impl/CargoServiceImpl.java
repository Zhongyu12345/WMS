package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Cargo;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.CargoMapper;
import com.wms.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoMapper cargoMapper;

	@Override
	public int deleteByPrimaryKey(Integer cId) {
		return cargoMapper.deleteByPrimaryKey(cId);
	}

	@Override
	public int insert(Cargo record) {
		return cargoMapper.insert(record);
	}

	@Override
	public int insertSelective(Cargo record) {
		return cargoMapper.insertSelective(record);
	}

	@Override
	public Cargo selectByPrimaryKey(Integer cId) {
		return cargoMapper.selectByPrimaryKey(cId);
	}

	@Override
	public Cargo selectByid(Integer cId) {
		return cargoMapper.selectByid(cId);
	}

	@Override
	public void select(PageInfo pageInfo) {
		Page<Cargo> page = new Page<>(pageInfo.getNowpage(),pageInfo.getSize());
		List<Cargo> list = cargoMapper.select(page,pageInfo.getCondition());
		pageInfo.setRows(list);
		pageInfo.setTotal(page.getTotal());
	}

	@Override
	public int updateByPrimaryKeySelective(Cargo record) {
		return cargoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Cargo record) {
		return cargoMapper.updateByPrimaryKey(record);
	}

	@Override
	public int update(Cargo cargo) {
		return cargoMapper.update(cargo);
	}

	@Override
	public int updatenum(Cargo cargo) {
		return cargoMapper.updatenum(cargo);
	}

	@Override
	public Cargo selectBySkumodel(String Skumodel) {
		return cargoMapper.selectBySkumodel(Skumodel);
	}
}
