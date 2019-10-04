package com.example.shiro.config;

import com.example.shiro.entities.SysPermission;
import com.example.shiro.entities.SysRole;
import com.example.shiro.entities.UserInfo;
import com.example.shiro.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyShiroRealm extends AuthorizingRealm {

    Logger logger= LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    UserInfoService userInfoService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        logger.info("------>权限配置");
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        UserInfo userInfo=(UserInfo)principalCollection.getPrimaryPrincipal();
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission permission:role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }


        return authorizationInfo;
    }

    @Override
    /***
     * 1、检查提交的进行认证的令牌信息
     *
     * 2、根据令牌信息从数据源(通常为数据库)中获取用户信息
     *
     * 3、对用户信息进行匹配验证。
     *
     * 4、验证通过将返回一个封装了用户信息的 AuthenticationInfo实例。
     *
     * 5、验证失败则抛出 AuthenticationException异常信息。
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("----->start authentication");
        //获取用户输入的账号
        String userName= (String) authenticationToken.getPrincipal();
        logger.info("----->"+authenticationToken.getCredentials());

        UserInfo userInfo=userInfoService.findByUserName(userName);

        logger.info("----->"+userInfo);

        if(userInfo==null){
            return null;
        }


        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(userInfo,userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getSalt()),getName());

        return authenticationInfo;
    }
}
