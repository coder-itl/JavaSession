package com.coderitl.service;

import com.coderitl.entity.Manager;

public interface ManagerService {
    // 用户登录
    public Manager login(String username, String password);
}
