package com.coderitl.service;

import com.coderitl.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    // 用户登录业务 根据用户 id 和 密码查询
    public UserInfo userLogin(String username, String password);

    // 查询所有
    public List<UserInfo> showAll();


}
