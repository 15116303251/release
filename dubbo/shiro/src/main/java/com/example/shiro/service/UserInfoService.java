package com.example.shiro.service;

import com.example.shiro.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoService extends JpaRepository<Integer, UserInfo> {


    public UserInfo findByUserName(String userName);
}
