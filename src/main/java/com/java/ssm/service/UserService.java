package com.java.ssm.service;

import com.java.ssm.bean.User;

import java.util.Map;

public interface UserService {
    User getUser(Map map);

    void insertUser(User user);
}
