package com.wms.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Notice;
import com.wms.commons.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.bean.Pay;
import com.wms.bean.vo.IncomeVo;
import com.wms.dao.PayMapper;
import com.wms.service.PayService;

import java.util.List;


@Service
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PayMapper payMapper;

	@Override
	public int deleteByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return payMapper.deleteByPrimaryKey(pid);
	}

	@Override
	public int insert(Pay record) {
		// TODO Auto-generated method stub
		return payMapper.insert(record);
	}

	@Override
	public int insertSelective(Pay record) {
		// TODO Auto-generated method stub
		return payMapper.insertSelective(record);
	}

	@Override
	public Pay selectByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return payMapper.selectByPrimaryKey(pid);
	}

	@Override
	public int updateByPrimaryKeySelective(Pay record) {
		// TODO Auto-generated method stub
		return payMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Pay record) {
		// TODO Auto-generated method stub
		return payMapper.updateByPrimaryKey(record);
	}

	@Override
	public IncomeVo selectByTime(String time) {
		return payMapper.selectByTime(time);
	}

	@Override
	public void selectDataGrid(PageInfo pageInfo) {
		Page<Pay> page = new Page<Pay>(pageInfo.getNowpage(), pageInfo.getSize());
		List<Pay> list = payMapper.selectDataGrid(page,pageInfo.getCondition());
		pageInfo.setRows(list);
		pageInfo.setTotal(page.getTotal());
	}

}
