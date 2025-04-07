package com.lu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 小卢
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insert() {
        userDao.insert();
        int i = 1/0;
    }
}
