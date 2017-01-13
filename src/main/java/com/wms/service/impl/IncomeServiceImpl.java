package com.wms.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Income;
import com.wms.bean.vo.IncomeVo;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.IncomeMapper;
import com.wms.service.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService{

	@Autowired
	private IncomeMapper incomeMapper;
	@Override
	public int deleteByPrimaryKey(Integer iid) {
		return incomeMapper.deleteByPrimaryKey(iid);
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

	@Override
	public IncomeVo selectByTime(String Timeyears) {
		return incomeMapper.selectByTime(Timeyears);
	}

	@Override
	public void selectDataGrid(PageInfo pageInfo) {
		Page<Income> page = new Page<Income>(pageInfo.getNowpage(), pageInfo.getSize());
        List<Income> list = incomeMapper.selectDataGrid(page, pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
	}

}
