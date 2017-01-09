package com.wms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Allotout;
import com.wms.commons.utils.OrderNumberUtil;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.AllotoutMapper;
import com.wms.service.AllotoutService;
import com.wms.service.GodownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/21.
 */
@Service
public class AllotoutServiceImpl implements AllotoutService {

    @Autowired
    private AllotoutMapper allotoutMapper;

    @Autowired
    private GodownService godownService;

    @Override
    public int addAllotout(Allotout allotout) {
        allotout.setAoSippingno(OrderNumberUtil.generateOrderNo());
        return allotoutMapper.insert(allotout);
    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<Allotout> page = new Page<Allotout>(pageInfo.getNowpage(), pageInfo.getSize());
        List<Allotout> list = allotoutMapper.selectAllotoutPage(page, pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public Allotout queryById(Integer id) {
        return allotoutMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteAllotout(Integer id) {
        Allotout allotout = queryById(id);
        if (allotout != null) {
            return allotoutMapper.deleteByPrimaryKey(id);
        } else {
            return 0;
        }
    }

    @Override
    public int updateAllotout(Allotout allotout) {
        return allotoutMapper.updateByPrimaryKey(allotout);
    }

    @SuppressWarnings("deprecation")
	@Override
    public int importAllotout(Allotout allotout) {
        //noinspection deprecation
        godownService.reduction(allotout.getAoWhid(), allotout.getAoVolume());
        return allotoutMapper.insert(allotout);
    }
}
