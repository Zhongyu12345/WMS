package com.wms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.CrossDatabase;
import com.wms.commons.utils.OrderNumberUtil;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.CrossDatabaseMapper;
import com.wms.service.CrossDatabaseService;
import com.wms.service.GodownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/19.
 */
@Service
public class CrossDatabaseServiceImpl implements CrossDatabaseService {

    @Autowired
    private CrossDatabaseMapper crossDatabaseMapper;

    @Autowired
    private GodownService godownService;

    @Override
    public List<CrossDatabase> queryAll() {
        return crossDatabaseMapper.queryAll();
    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<CrossDatabase> page = new Page<CrossDatabase>(pageInfo.getNowpage(), pageInfo.getSize());
        List<CrossDatabase> list = crossDatabaseMapper.selectCrossDatabasePage(page, pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public CrossDatabase selectById(Integer id) {
        return crossDatabaseMapper.selectByPrimaryKey(id);
    }

    @SuppressWarnings("deprecation")
	@Transactional
    @Override
    public int addCrossDatabase(CrossDatabase crossDatabase) {
        crossDatabase.setCdOddnumbers(OrderNumberUtil.generateOrderNo());
        //noinspection deprecation
        godownService.reduction(crossDatabase.getCdWhid(), crossDatabase.getCdVolume());
        return crossDatabaseMapper.insert(crossDatabase);
    }

    @Override
    public int deleteById(Integer id) {
        CrossDatabase crossDatabase = selectById(id);
        if (crossDatabase != null) {
            return crossDatabaseMapper.deleteByPrimaryKey(id);
        } else {
            //没有此ID
            return 0;
        }
    }

    /**
     * Selective 为动态SQL
     *
     * @param crossDatabase
     * @return
     */
    @Override
    public int updateCrossDatabase(CrossDatabase crossDatabase) {
        return crossDatabaseMapper.updateByPrimaryKeySelective(crossDatabase);
    }

    @SuppressWarnings("deprecation")
	@Override
    public int importCrossDatabase(CrossDatabase crossDatabase) {
        //noinspection deprecation
        godownService.reduction(crossDatabase.getCdWhid(), crossDatabase.getCdVolume());
        return crossDatabaseMapper.insert(crossDatabase);
    }

}
