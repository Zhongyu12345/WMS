package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.MakeInventory;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.MakeInventoryMapper;
import com.wms.service.MakeInventoryService;

/**
 * Created by DengMin on 2016/12/23.
 */
@Service
public class MakeInventoryServiceImpl implements MakeInventoryService {

    @Autowired
    private MakeInventoryMapper makeInventoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer miId) {
        return makeInventoryMapper.deleteByPrimaryKey(miId);
    }

    @Override
    public int insert(MakeInventory record) {
        return makeInventoryMapper.insert(record);
    }

    @Override
    public int insertSelective(MakeInventory record) {
        return makeInventoryMapper.insertSelective(record);
    }

    @Override
    public MakeInventory selectByPrimaryKey(Integer miId) {
        return makeInventoryMapper.selectByPrimaryKey(miId);
    }

    @Override
    public void select(PageInfo pageInfo) {
        Page<MakeInventory> page = new Page<MakeInventory>(pageInfo.getNowpage(),pageInfo.getSize());
        List<MakeInventory> list = makeInventoryMapper.select(page,pageInfo.getCondition());
       pageInfo.setRows(list);
       pageInfo.setTotal(page.getTotal());
    }

    @Override
    public int updateByPrimaryKeySelective(MakeInventory record) {
        return makeInventoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MakeInventory record) {
        return makeInventoryMapper.updateByPrimaryKey(record);
    }

	@Override
	public List<MakeInventory> selectByOrder(String order) {
		return makeInventoryMapper.selectByOrder(order);
	}
}
