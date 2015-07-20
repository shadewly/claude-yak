package com.shine.his.usrcenter.service;

import com.shine.his.common.exception.HISException;
import com.shine.his.common.service.HISService;
import com.shine.his.usrcenter.pojo.User;

/**
 * Created by claude on 15-6-30.
 */
public interface UserService extends HISService {

    /**
     * Find user by name
     *
     * @param name the login name of the user.
     * @return
     */
    public User findUserByName(String name) throws HISException;

    /**
     * Create new user
     *
     * @param user
     * @throws HISException
     */
    public void createUser(User user) throws HISException;
}
