package com.king.dubbo.user.service;

import com.king.dubbo.entities.model.user.UserInfo;
import com.king.dubbo.service.user.UserService;
import com.king.dubbo.user.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserByUserName(String username) {
        return userInfoMapper.selectByUserName(username);
    }
}
