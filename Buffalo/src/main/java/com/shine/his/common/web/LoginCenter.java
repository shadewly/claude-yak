package com.shine.his.common.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.shine.his.common.exception.HISException;

/**
 * Created by claude on 15-6-26.
 */
@Path("/loginCenter")
public class LoginCenter {

    @GET
    @Path("/loginEntry")
    public String loginEntry() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isRemembered()) {
            return "Hi " + subject.getPrincipal() + " pls. login!";
        }
        return "pls. login in!";
    }

    @GET
    @Path("/login/{name}")
    public String loginExam(@PathParam("name") String name, @PathParam("password") String password) throws HISException {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "user is Authenticated!";
        }

        password = "234567890";
        UsernamePasswordToken token = null;
        if (name == null) {
            throw new HISException("Pls. enter user name!");
        } else if (password == null) {
            throw new HISException("Pls. enter password!");
        }

        token = new UsernamePasswordToken(name, password, true);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "user login success now!";
    }
}
