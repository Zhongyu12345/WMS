package com.wms.service;

import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.User;
import com.wms.bean.vo.UserVo;
import com.wms.commons.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * User 表数据服务层接口
 */
public interface IUserService extends ISuperService<User> {

    List<User> selectByLoginName(UserVo userVo);

    void insertByVo(UserVo userVo);

    UserVo selectVoById(Long id);

    List<UserVo> selectUserBytype(Map<String,Object>map);

    void updateByVo(UserVo userVo);

    void updatePwdByUserId(Long userId, String md5Hex);

    void selectDataGrid(PageInfo pageInfo);

    void deleteUserById(Long id);

    UserVo selectByloginname(String user);

    List<UserVo> selectByRole();

    int add(User user);
}