package com.wms.dao;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.wms.bean.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRole 表数据库控制层接口
 */
@Repository
public interface UserRoleMapper extends AutoMapper<UserRole> {

    List<UserRole> selectByUserId(@Param("userId") Long userId);

    List<Long> selectRoleIdListByUserId(@Param("userId") Long userId);

}