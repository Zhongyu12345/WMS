package com.wms.service;

import com.baomidou.framework.service.ISuperService;
import com.wms.bean.SysLog;
import com.wms.commons.utils.PageInfo;

/**
 * SysLog 表数据服务层接口
 */
public interface ISysLogService extends ISuperService<SysLog> {

    void selectDataGrid(PageInfo pageInfo);

}