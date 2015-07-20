package com.shine.his.usrcenter.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shine.his.common.exception.HISException;
import com.shine.his.common.util.StringUtil;
import com.shine.his.usrcenter.Exception.UserNotFoundException;
import com.shine.his.usrcenter.dao.UserDao;
import com.shine.his.usrcenter.pojo.User;

/**
 * Created by claude on 15-6-30.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User findUserByName(String name) throws UserNotFoundException {
        if (StringUtil.isBlank(name)) {
            throw new UserNotFoundException("Can't found user " + name);
        }
        User user = userDao.findByUsername(name);
        if (user == null) {
            throw new UserNotFoundException("Can't found user " + name);
        } else {
            return user;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createUser(User user) throws HISException {
        //validate user?
        user.setCreateDate(new Date());
        if (user.getCreateId() == null) {
            throw new HISException("Creator user id is required!");
        }
        userDao.save(user);
    }

}
