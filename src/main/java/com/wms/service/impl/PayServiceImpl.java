package com.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.bean.Pay;
import com.wms.bean.vo.IncomeVo;
import com.wms.dao.PayMapper;
import com.wms.service.PayService;

@Service
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PayMapper payMapper;

	@Override
	public int deleteByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Pay record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Pay record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pay selectByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Pay record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Pay record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IncomeVo selectByTime(String time) {
		return payMapper.selectByTime(time);
	}

}
