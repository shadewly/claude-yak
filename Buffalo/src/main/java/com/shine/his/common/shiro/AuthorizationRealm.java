package com.shine.his.common.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shine.his.common.web.WebUtil;
import com.shine.his.usrcenter.dao.UserDao;
import com.shine.his.usrcenter.pojo.User;

/**
 * Created by claude on 15-6-10.
 */
@Service("authorizationRealm")
public class AuthorizationRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(AuthorizationRealm.class);
    @Autowired
    UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    @Transactional(value = "txManager", propagation = Propagation.REQUIRED)
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null username is not allowed by this realm.");
        }

        User user = null;
        try {
            user = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Find user error for name [" + username + "]", e);
        }
        if (user == null) {
            throw new UnknownAccountException("No account found for user [" + username + "]");
        }
        WebUtil.cacheUser(user);
        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(username, user.getPassword().toCharArray(), getName());
        String salt = user.getName();
        if (salt != null) {
            info.setCredentialsSalt(ByteSource.Util.bytes(salt));
        }
        return info;
    }

}