package com.coderitl.dao;

import com.coderitl.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    public UserInfo selectOne(String username);

    public List<UserInfo> selectAll();
}
