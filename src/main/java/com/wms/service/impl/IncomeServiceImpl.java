package com.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.bean.Income;
import com.wms.dao.IncomeMapper;
import com.wms.service.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService{

	@Autowired
	private IncomeMapper incomeMapper;
	@Override
	public int deleteByPrimaryKey(Integer iid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Income record) {
		return incomeMapper.insert(record);
	}

	@Override
	public int insertSelective(Income record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Income selectByPrimaryKey(Integer iid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Income record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Income record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
