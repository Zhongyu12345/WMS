package com.wms.service.impl;

import com.wms.bean.Godown;
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

    /** 查询所有仓库 EasyUI下拉框操作 */
    @Override
    public List<Godown> godownComboBox() {
        return godownMapper.findByComboBox4EasyUi();
    }

}