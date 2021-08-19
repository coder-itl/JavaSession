package com.coderitl.service.impl;

import com.coderitl.dao.ManagerDao;
import com.coderitl.dao.impl.ManagerDaoImpl;
import com.coderitl.entity.Manager;
import com.coderitl.service.ManagerService;
import com.coderitl.utils.Utils;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public Manager login(String username, String password) {
        Manager manager = null;
        try {
            // 开启事务控制
            Utils.begin();
            // 调用业务逻辑
            Manager selectManager = managerDao.select(username);
            if (selectManager != null) {
                // 对密码处理
                if (selectManager.getPassword().equals(password)) {
                    manager = selectManager;
                }
            }
            Utils.commit();
        } catch (Exception e) {
            Utils.rollback();
            e.printStackTrace();
        }
        return manager;
    }
}
