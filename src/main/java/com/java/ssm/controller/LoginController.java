package com.java.ssm.controller;

import com.java.ssm.bean.User;
import com.java.ssm.service.UserService;
import com.java.ssm.utils.MD5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    private static Log log = LogFactory.getLog(LoginController.class);
    @Autowired
    private UserService userServiceImpl;
    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session, Model model){
        String userpassword = MD5Util.MD5(MD5Util.MD5(password));
        Map map = new HashMap();
        map.put("username",username);
        map.put("password",userpassword);
        User user = userServiceImpl.getUser(map);
        //判断用户对象是否为空
        if(user==null){
            return "page/login";
        }else{
            session.setAttribute("userInfo",user);
            return "page/login_success";
        }

    }
}
