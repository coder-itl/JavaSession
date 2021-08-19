package com.coderitl.service;

import com.coderitl.entity.Manager;

public interface ManagerService {
    // 实现管理员登录
    public Manager login(String username, String passwword);
}
