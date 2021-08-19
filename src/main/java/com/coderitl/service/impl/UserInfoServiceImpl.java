package com.coderitl.service.impl;

import com.coderitl.dao.UserInfoDao;
import com.coderitl.dao.impl.UserInfoDaoImpl;
import com.coderitl.entity.UserInfo;
import com.coderitl.service.UserInfoService;
import com.coderitl.utils.Utils;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();

    @Override
    public UserInfo userLogin(String username, String password) {
        UserInfo result = null;
        // 做什么事？
        try {
            // 1. 开启事务
            Utils.begin();
            // 2. 查询
            UserInfo userInfo = userInfoDao.selectOne(username);
            if (userInfo != null) {
                if (userInfo.getPassword().equals(password)) {
                    result = userInfo;
                }
            }
            Utils.commit();
        } catch (Exception e) {
            Utils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<UserInfo> showAll() {
        List<UserInfo> userInfos = null;
        // 开启事务
        try {
            Utils.begin();
            userInfos = userInfoDao.selectAll();
            Utils.commit();
        } catch (Exception e) {
            Utils.rollback();
            e.printStackTrace();
        }
        return userInfos;
    }
}
