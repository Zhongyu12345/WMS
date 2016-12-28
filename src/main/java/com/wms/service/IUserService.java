package com.wms.service;

import com.baomidou.framework.service.ISuperService;
import com.wms.bean.User;
import com.wms.bean.vo.UserVo;
import com.wms.commons.utils.PageInfo;

import java.util.List;

/**
 * User 表数据服务层接口
 */
public interface IUserService extends ISuperService<User> {

    List<User> selectByLoginName(UserVo userVo);

    void insertByVo(UserVo userVo);

    UserVo selectVoById(Long id);

    void updateByVo(UserVo userVo);

    void updatePwdByUserId(Long userId, String md5Hex);

    void selectDataGrid(PageInfo pageInfo);

    void deleteUserById(Long id);
    
    List<UserVo> selectByRole();
}