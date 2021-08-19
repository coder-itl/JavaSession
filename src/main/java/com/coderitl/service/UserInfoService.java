package com.coderitl.service;

import com.coderitl.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    // service 主要实现业务功能 普通用户
    public UserInfo userLogin(String username, String password);

    public List<UserInfo> showAll();
}
