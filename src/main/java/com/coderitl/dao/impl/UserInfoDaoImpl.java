package com.coderitl.dao.impl;

import com.coderitl.dao.UserInfoDao;
import com.coderitl.entity.UserInfo;

import com.coderitl.utils.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public UserInfo selectOne(String username) {
        try {
            String sql = "select * from userinfo where username = ?";
            // dao 实现类要怎么做? 使用 QueryRunner 调用方法
            UserInfo queryOne = queryRunner.query(Utils.getConnection(), sql, new BeanHandler<UserInfo>(UserInfo.class), username);
            return queryOne;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserInfo> selectAll() {
        try {
            List<UserInfo> userList = queryRunner.query(Utils.getConnection(), "select * from userinfo", new BeanListHandler<UserInfo>(UserInfo.class));
            return userList;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
