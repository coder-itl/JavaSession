package com.coderitl.dao.impl;

import com.coderitl.dao.ManagerDao;
import com.coderitl.entity.Manager;
import com.coderitl.utils.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public Manager select(String username) {
        try {
            String sql = "select * from manager where username=?";
            Manager manager = queryRunner.query(Utils.getConnection(), sql, new BeanHandler<Manager>(Manager.class), username);
            return manager;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
