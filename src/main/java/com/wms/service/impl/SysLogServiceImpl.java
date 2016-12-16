package com.wms.service.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Role;
import com.wms.bean.SysLog;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.SysLogMapper;
import com.wms.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SysLog 表数据服务层接口实现类
 */
@Service
public class SysLogServiceImpl extends SuperServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<SysLog> page = new Page<SysLog>(pageInfo.getNowpage(), pageInfo.getSize());
        List<Role> list = sysLogMapper.selectSysLogList(page);
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

}