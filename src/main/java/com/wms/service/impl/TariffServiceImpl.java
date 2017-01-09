package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Tariff;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.TariffMapper;
import com.wms.service.TariffService;

@Service
public class TariffServiceImpl implements TariffService{
	
	@Autowired
	private TariffMapper tariffMapper;

	@Override
	public int deleteByPrimaryKey(Integer iid) {
		return tariffMapper.deleteByPrimaryKey(iid);
	}

	@Override
	public int insert(Tariff tariff) {
		return tariffMapper.insert(tariff);
	}

	@Override
	public int insertSelective(Tariff tariff) {
		return tariffMapper.insertSelective(tariff);
	}

	@Override
	public Tariff selectByPrimaryKey(Integer iid) {
		return tariffMapper.selectByPrimaryKey(iid);
	}

	@Override
	public int updateByPrimaryKeySelective(Tariff tariff) {
		return tariffMapper.updateByPrimaryKeySelective(tariff);
	}

	@Override
	public int updateByPrimaryKey(Tariff tariff) {
		return tariffMapper.updateByPrimaryKey(tariff);
	}

	@Override
	public void selectDataGrid(PageInfo pageInfo) {
		Page<Tariff> page = new Page<Tariff>(pageInfo.getNowpage(), pageInfo.getSize());
        List<Tariff> list = tariffMapper.selectDataGrid(page, pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
	}

	@Override
	public List<Tariff> selectByCause() {
		return tariffMapper.selectByCause();
	}

}
