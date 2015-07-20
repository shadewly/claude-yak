package com.shine.his.usrcenter.web;

import javax.ws.rs.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.shine.his.common.exception.HISException;
import com.shine.his.common.web.WebUtil;
import com.shine.his.usrcenter.pojo.User;
import com.shine.his.usrcenter.service.UserService;

/**
 * Created by claude on 15-6-30.
 */
@Path("users")
@Controller
public class UserView {
    private static Logger logger = LoggerFactory.getLogger(UserView.class);
    @Autowired
    private UserService userService;

    @Path("{name}")
    @GET
    public String getUserByName(@PathParam("name") String name) throws HISException {
        logger.debug("Get user by Name [" + name + "]");
        return userService.findUserByName(name).getName();
    }

    @Path("/newUser")
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public String addUser(String jsonData) throws HISException {
        User user = null;
        user = JSON.parseObject(jsonData, User.class);
        user.setCreateId(WebUtil.getLoginUser().getId());

        userService.createUser(user);
        return jsonData;
    }

}
