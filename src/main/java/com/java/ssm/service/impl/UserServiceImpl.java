package com.java.ssm.service.impl;

import com.java.ssm.bean.User;
import com.java.ssm.dao.UserMapper;
import com.java.ssm.service.UserService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Map map) {
        User user = userMapper.getUser(map);
        return user;
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
        System.out.println(1/0);
    }
}
