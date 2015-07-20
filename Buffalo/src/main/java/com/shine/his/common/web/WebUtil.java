package com.shine.his.common.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.shine.his.usrcenter.pojo.User;

/**
 * Created by claude on 15-7-2.
 */
public class WebUtil {
    static String CURRENT_USER = "currentUser";

    public static User getLoginUser() {
        Subject subject = SecurityUtils.getSubject();
        return (User) subject.getSession().getAttribute(CURRENT_USER);
    }

    public static void cacheUser(User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.getSession(true).setAttribute(CURRENT_USER, user);
    }
}
