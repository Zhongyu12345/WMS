package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.CargoBorrow;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.CargoBorrowMapper;
import com.wms.service.CargoBorrowService;

/**
 * Created by DengMin on 2016/12/21.
 */
@Service
public class CargoBorrowServiceImpl implements CargoBorrowService{

    @Autowired
    private CargoBorrowMapper cargoborrowmapper;

    @Override
    public int deleteByPrimaryKey(Integer cbId) {
        return cargoborrowmapper.deleteByPrimaryKey(cbId);
    }

    @Override
    public int insert(CargoBorrow record) {
        return cargoborrowmapper.insert(record);
    }

    @Override
    public int insertSelective(CargoBorrow record) {
        return cargoborrowmapper.insertSelective(record);
    }

    @Override
    public CargoBorrow selectByPrimaryKey(Integer cbId) {
        return cargoborrowmapper.selectByPrimaryKey(cbId);
    }

    @Override
    public void select(PageInfo pageInfo) {
        Page<CargoBorrow> page = new Page<>(pageInfo.getNowpage(),pageInfo.getPagesize());
        List<CargoBorrow> list = cargoborrowmapper.select(page,pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public int updateByPrimaryKeySelective(CargoBorrow record) {
        return cargoborrowmapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CargoBorrow record) {
        return cargoborrowmapper.updateByPrimaryKey(record);
    }
}
