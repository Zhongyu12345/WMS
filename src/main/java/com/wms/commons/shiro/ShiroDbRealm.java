package com.wms.commons.shiro;

import com.wms.bean.User;
import com.wms.bean.vo.UserVo;
import com.wms.commons.utils.StringUtils;
import com.wms.service.IRoleService;
import com.wms.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * shiro权限认证
 */
public class ShiroDbRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    /**
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UserVo uservo = new UserVo();
        uservo.setLoginName(token.getUsername());
        List<User> list = userService.selectByLoginName(uservo);
        //账号不存在
        if (list == null || list.isEmpty()) {
            return null;
        }
        User user = list.get(0);
        //账号未启用
        if (user.getStatus() == 1) {
            return null;
        }
        List<Long> roleList = roleService.selectRoleIdListByUserId(user.getId());
        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getLoginName(), user.getName(), roleList);
        //认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), getName());

    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        List<Long> roleList = shiroUser.roleList;
        Set<String> urlSet = new HashSet<String>();
        for (Long roleId : roleList) {
            List<Map<Long, String>> roleResourceList = roleService.selectRoleResourceListByRoleId(roleId);
            if (roleResourceList != null) {
                for (Map<Long, String> map : roleResourceList) {
                    if (StringUtils.isNotBlank(map.get("url"))) {
                        urlSet.add(map.get("url"));
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(urlSet);
        return info;
    }
}
