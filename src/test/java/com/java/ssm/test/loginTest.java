package com.java.ssm.test;

import com.java.ssm.bean.User;
import com.java.ssm.service.TestService;
import com.java.ssm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class loginTest {

    @Test
    public void getUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        UserService userService = (UserService) ac.getBean("userServiceImpl");
        TestService testService = (TestService) ac.getBean("testServiceImpl");
        Map map = new HashMap();
        map.put("username","test");
        map.put("password","123456");
        User user = userService.getUser(map);
        User user1 = new User(2,"111","111");
        User user2 = new User(3,"222","222");
        testService.insertTest(user2);
        userService.insertUser(user1);
        System.out.println(user);
    }
}
