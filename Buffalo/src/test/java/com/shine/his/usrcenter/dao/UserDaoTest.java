package com.shine.his.usrcenter.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.shine.his.usrcenter.pojo.User;

/**
 * Created by claude on 15-6-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getName());
        }
    }
}
