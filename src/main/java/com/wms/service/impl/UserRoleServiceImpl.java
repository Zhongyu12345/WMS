package com.wms.service.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.wms.bean.UserRole;
import com.wms.dao.UserRoleMapper;
import com.wms.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * UserRole 表数据服务层接口实现类
 */
@Service
public class UserRoleServiceImpl extends SuperServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}