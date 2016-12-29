package com.wms.service;

import com.wms.bean.Allotout;
import com.wms.commons.utils.PageInfo;

/**
 * Created by ZhongYu on 2016/12/21.
 */
public interface AllotoutService {

    /**
     * 添加调拨出库单
     *
     * @param allotout
     * @return
     */
    int addAllotout(Allotout allotout);

    void selectDataGrid(PageInfo pageInfo);

    Allotout queryById(Integer id);

    int deleteAllotout(Integer id);

    int updateAllotout(Allotout allotout);

    int importAllotout(Allotout allotout);

}