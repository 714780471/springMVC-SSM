package com.java.ssm.service.impl;

import com.java.ssm.bean.User;
import com.java.ssm.dao.UserMapper;
import com.java.ssm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insertTest(User user) {
        userMapper.insert(user);
    }
}
