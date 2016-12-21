package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Allotput;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.AllotputMapper;
import com.wms.service.AllotputService;

@Service
public class AllotputServiceImpl implements AllotputService {
	
	@Autowired
	private AllotputMapper allotput;

	@Override
	public int deleteByPrimaryKey(Integer apId) {
		return allotput.deleteByPrimaryKey(apId);
	}

	@Override
	public int insert(Allotput record) {
		return allotput.insert(record);
	}

	@Override
	public int insertSelective(Allotput record) {
		return allotput.insertSelective(record);
	}

	@Override
	public Allotput selectByPrimaryKey(Integer apId) {
		return allotput.selectByPrimaryKey(apId);
	}

	@Override
	public void selectAll(PageInfo pageinfo) {
		Page<Allotput> page  = new Page<Allotput>(pageinfo.getNowpage(),pageinfo.getPagesize());
		List<Allotput> list = allotput.selectAll(page);
		pageinfo.setRows(list);
		pageinfo.setTotal(page.getTotal());
	}

	@Override
	public int updateByPrimaryKeySelective(Allotput record) {
		return allotput.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Allotput record) {
		return allotput.updateByPrimaryKey(record);
	}

}
