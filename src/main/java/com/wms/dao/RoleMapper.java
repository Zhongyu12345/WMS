package com.wms.dao;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Resource;
import com.wms.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Role 表数据库控制层接口
 */
@Repository
public interface RoleMapper extends AutoMapper<Role> {

    List<Role> selectAll();

    List<Long> selectResourceIdListByRoleId(@Param("id") Long id);

    List<Resource> selectResourceIdListByRoleIdAndType(@Param("id") Long id);

    List<Map<Long, String>> selectResourceListByRoleId(@Param("id") Long id);

    List<Role> selectRoleList(Pagination page, @Param("sort") String sort, @Param("order") String order);

}