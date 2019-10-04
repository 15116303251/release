package com.king.dubbo.service.user;

import com.king.dubbo.entities.model.user.UserInfo;

public interface UserService {

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return
     */
    public UserInfo getUserByUserName(String username);
}
