package com.wms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Godown;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.GodownMapper;
import com.wms.service.GodownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/26.
 */
@Service
public class GodownServiceImpl implements GodownService {

    @Autowired
    private GodownMapper godownMapper;

    /**
     * 查询所有仓库 EasyUI下拉框操作
     */
    @Override
    public List<Godown> godownComboBox() {
        return godownMapper.findByComboBox4EasyUi();
    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<Godown> page = new Page<Godown>(pageInfo.getNowpage(), pageInfo.getSize());
        List<Godown> list = godownMapper.selectDataGrid(page, pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public int updateByPrimaryKey(Godown record) {
        return godownMapper.updateByPrimaryKey(record);
    }

    @Override
    public Godown selectByPrimaryKey(Integer goId) {
        return godownMapper.selectByPrimaryKey(goId);
    }

    public int insert(Godown godown) {
        return godownMapper.insert(godown);
    }

    @Override
    public int updateStatus(Godown godown) {
        return godownMapper.updateByPrimaryKeySelective(godown);
    }

    @Override
    public Godown selectById(int id) {
        return godownMapper.selectByPrimaryKey(id);
    }

    @Override
    public Godown selectByWhid(String whid) {
        return godownMapper.selectByWhid(whid);
    }

    @Override
    public int reduction(String id, Double volume) {
    	Godown godowns = godownMapper.selectByWhid(id);
        Godown godown = selectById(godowns.getGoId());
        godown.setGoUsevolume(godown.getGoUsevolume() - volume);
        godown.setGoRdvolume(godown.getGoRdvolume() + volume);
        return updateByPrimaryKey(godown);
    }

}