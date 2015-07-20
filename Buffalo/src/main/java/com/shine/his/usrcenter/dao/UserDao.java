package com.shine.his.usrcenter.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.shine.his.common.mybatis.MybatisMapperAnnotation;
import com.shine.his.usrcenter.pojo.User;

/**
 * Created by claude on 15-6-11.
 */
@Repository
@Scope("singleton")
@MybatisMapperAnnotation
public interface UserDao {

    public User findByUsername(String name);

    public List<User> findAll();

    public void save(User user);
}