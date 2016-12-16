package com.wms.service.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.wms.bean.RoleResource;
import com.wms.dao.RoleResourceMapper;
import com.wms.service.IRoleResourceService;
import org.springframework.stereotype.Service;

/**
 * RoleResource 表数据服务层接口实现类
 */
@Service
public class RoleResourceServiceImpl extends SuperServiceImpl<RoleResourceMapper, RoleResource> implements IRoleResourceService {

}