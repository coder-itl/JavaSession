package com.coderitl.dao;

import com.coderitl.entity.Manager;
import com.coderitl.entity.UserInfo;

public interface ManagerDao {
    // 根据用户名查询 管理员
    public Manager select(String username);
}
    