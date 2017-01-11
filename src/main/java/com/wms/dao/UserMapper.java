package com.wms.dao;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.User;
import com.wms.bean.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * User 表数据库控制层接口
 */
@Repository
public interface UserMapper extends AutoMapper<User> {

    UserVo selectUserVoById(@Param("id") Long id);

    List<UserVo> selectUserVoPage(Pagination page, Map<String, Object> params);

    UserVo selectByloginname(String user);

    List<UserVo> selectUserBytype(Map<String,Object> map);

    List<UserVo> selectByRole();

    int add(User user);

}