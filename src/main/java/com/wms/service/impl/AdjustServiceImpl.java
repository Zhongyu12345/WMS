package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Adjust;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.AdjustMapper;
import com.wms.service.AdjustService;

/**
 * Created by DengMin on 2016/12/20.
 */
@Service
public class AdjustServiceImpl implements AdjustService{

    @Autowired
    private AdjustMapper adjustmapper;

    @Override
    public int deleteByPrimaryKey(Integer jId) {
        return adjustmapper.deleteByPrimaryKey(jId);
    }

    @Override
    public int insert(Adjust record) {
        return adjustmapper.insert(record);
    }

    @Override
    public int insertSelective(Adjust record) {
        return adjustmapper.insertSelective(record);
    }

    @Override
    public List<Adjust> selectByPrimaryKey(Integer jId) {
        return adjustmapper.selectByPrimaryKey(jId);
    }

    @Override
    public void select(PageInfo pageinfo) {
        Page<Adjust> page = new Page<>(pageinfo.getNowpage(),pageinfo.getSize());
        List<Adjust> list = adjustmapper.select(page,pageinfo.getCondition());
        pageinfo.setRows(list);
        pageinfo.setTotal(page.getTotal());
    }

    @Override
    public int updateByPrimaryKeySelective(Adjust record) {
        return adjustmapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Adjust record) {
        return adjustmapper.updateByPrimaryKey(record);
    }
}
