package com.coderitl.service.impl;

import com.coderitl.dao.UserInfoDao;
import com.coderitl.dao.impl.UserInfoDaoImpl;
import com.coderitl.entity.UserInfo;
import com.coderitl.service.UserInfoService;
import com.coderitl.utils.Utils;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {

    // TODO: 为什么要这样做 :=> 联想用户登录要操作的业务逻辑
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();

    @Override
    public UserInfo userLogin(String username, String password) {
        UserInfo result = null;
        try {
            // 开启事务
            Utils.begin();
            // service 又要怎么操作
            UserInfo userInfo = userInfoDao.selectOne(username);

            if (userInfo != null) {
                // 就是查询到结果，返回给 servlet
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
