package com.coderitl.dao;

import com.coderitl.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {


    public int insert(UserInfo userInfo);

    public int update(int id);

    public int delete(int id);

    public UserInfo selectOne(String username);

    public List<UserInfo> selectAll();


}
