package com.coderitl.dao.impl;

import com.coderitl.dao.UserInfoDao;
import com.coderitl.entity.UserInfo;
import com.coderitl.utils.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public int insert(UserInfo userInfo) {

        return 0;
    }

    @Override
    public int update(int id) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public UserInfo selectOne(String username) {
        try {
            String sql = "select * from userinfo where username=?";
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
            String sql = "select * from userinfo";
            List<UserInfo> userList = queryRunner.query(Utils.getConnection(), sql, new BeanListHandler<UserInfo>(UserInfo.class));
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
