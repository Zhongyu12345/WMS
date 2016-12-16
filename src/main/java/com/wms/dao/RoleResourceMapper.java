package com.wms.dao;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.wms.bean.RoleResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * RoleResource 表数据库控制层接口
 */
@Repository
public interface RoleResourceMapper extends AutoMapper<RoleResource> {

    Long selectIdListByRoleId(@Param("id") Long id);

}