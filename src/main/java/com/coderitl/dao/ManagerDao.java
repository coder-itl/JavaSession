package com.coderitl.dao;

import com.coderitl.entity.Manager;

public interface ManagerDao {
    // 查询操作
    public Manager select(String username);
}
