package com.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.bean.GodownEntry;
import com.wms.dao.GodownEntryMapper;
import com.wms.service.GodownEntryService;

@Service
public class GodwnEntryServiceImpl  implements GodownEntryService {

	@Autowired
	private GodownEntryMapper godownEntryMapper;

	@Override
	public int deleteByPrimaryKey(Integer gId) {
		return godownEntryMapper.deleteByPrimaryKey(gId);
	}

	@Override
	public int insert(GodownEntry record) {
		return godownEntryMapper.insert(record);
	}

	@Override
	public int insertSelective(GodownEntry record) {
		return godownEntryMapper.insertSelective(record);
	}

	@Override
	public GodownEntry selectByPrimaryKey(Integer gId) {
		return godownEntryMapper.selectByPrimaryKey(gId);
	}

	@Override
	public int updateByPrimaryKeySelective(GodownEntry record) {
		return godownEntryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GodownEntry record) {
		return godownEntryMapper.updateByPrimaryKey(record);
	}

	@Override
	public GodownEntry selectByNo(String No) {
		return godownEntryMapper.selectByNo(No);
	}
}
