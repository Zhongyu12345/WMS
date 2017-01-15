package com.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.bean.Compay;
import com.wms.dao.CompayMapper;
import com.wms.service.CompayService;

@Service
public class CompayServiceImpl implements CompayService{

	@Autowired
	private CompayMapper compayMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer caid) {
		// TODO Auto-generated method stub
		return compayMapper.deleteByPrimaryKey(caid);
	}

	@Override
	public int insert(Compay record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Compay record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Compay selectByPrimaryKey(Integer caid) {
		return compayMapper.selectByPrimaryKey(caid);
	}

	@Override
	public int updateByPrimaryKeySelective(Compay record) {
		return compayMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Compay record) {
		return compayMapper.updateByPrimaryKey(record);
	}

	@Override
	public Compay selectAll() {
		return compayMapper.selectAll();
	}
	
}
