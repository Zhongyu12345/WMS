package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.GiveBack;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.GiveBackMapper;
import com.wms.service.GiveBackService;

/**
 * Created by DengMin on 2016/12/23.
 */
@Service
public class GiveBackServiceImpl implements GiveBackService {

    @Autowired
    private GiveBackMapper giveBackMapper;

    @Override
    public int deleteByPrimaryKey(Integer gbId) {
        return giveBackMapper.deleteByPrimaryKey(gbId);
    }

    @Override
    public int insert(GiveBack record) {
        return giveBackMapper.insert(record);
    }

    @Override
    public int insertSelective(GiveBack record) {
        return giveBackMapper.insertSelective(record);
    }

    @Override
    public GiveBack selectByPrimaryKey(Integer gbId) {
        return giveBackMapper.selectByPrimaryKey(gbId);
    }

    @Override
    public void select(PageInfo pageInfo) {
        Page<GiveBack> page = new Page<GiveBack>(pageInfo.getNowpage(),pageInfo.getSize());
        List<GiveBack> list = giveBackMapper.select(page,pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public int updateByPrimaryKeySelective(GiveBack record) {
        return giveBackMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GiveBack record) {
        return giveBackMapper.updateByPrimaryKey(record);
    }
}
