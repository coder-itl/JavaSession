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
            Utils.begin();
            Manager select = managerDao.select(username);
            if (select != null) {
                if (select.getPassword().equals(password)) {
                    manager = select;
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
