package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.GodownEntry;
import com.wms.commons.utils.PageInfo;
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

	@Override
	public void selectAll(PageInfo pageinfo) {
		Page<GodownEntry> page  = new Page<GodownEntry>(pageinfo.getNowpage(),pageinfo.getPagesize());
		List<GodownEntry> list = godownEntryMapper.selectAll(page,pageinfo.getCondition());
		pageinfo.setRows(list);
		pageinfo.setTotal(page.getTotal());
	}
}
