package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Receiving;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.ReceivingMapper;
import com.wms.service.ReceivingService;

@Service
public class ReceivingServiceImpl implements ReceivingService {
	
	@Autowired
	private ReceivingMapper receivingMapper;

	@Override
	public int deleteByPrimaryKey(Integer rId) {
		return receivingMapper.deleteByPrimaryKey(rId);
	}

	@Override
	public int insert(Receiving record) {
		return receivingMapper.insert(record);
	}

	@Override
	public int insertSelective(Receiving record) {
		return receivingMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Receiving record) {
		return receivingMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Receiving record) {
		return receivingMapper.updateByPrimaryKey(record);
	}

	@Override
	public Receiving selectByPrimaryKey(Integer rId) {
		return receivingMapper.selectByPrimaryKey(rId);
	}

	@Override
	public void selectAll(PageInfo pageinfo) {
		Page<Receiving> page  = new Page<Receiving>(pageinfo.getNowpage(),pageinfo.getPagesize());
<<<<<<< Updated upstream
		List<Receiving> list = receivingMapper.selectAll(page,pageinfo.getCondition());
=======
		List<Receiving> list = receivingMapper.selectAll(page);
>>>>>>> Stashed changes
		pageinfo.setRows(list);
		pageinfo.setTotal(page.getTotal());
	}

}
