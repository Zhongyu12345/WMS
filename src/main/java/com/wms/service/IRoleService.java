package com.wms.service;

import com.baomidou.framework.service.ISuperService;
import com.wms.bean.Role;
import com.wms.commons.utils.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Role 表数据服务层接口
 */
public interface IRoleService extends ISuperService<Role> {

    List<Long> selectRoleIdListByUserId(Long userId);

    List<Map<Long, String>> selectRoleResourceListByRoleId(Long roleId);

    void selectDataGrid(PageInfo pageInfo);

    Object selectTree();

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id, String resourceIds);

}