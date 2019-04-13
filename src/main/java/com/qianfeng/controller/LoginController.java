package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonBean login(String no, String pass){
        try {
            userService.login(no, pass);
            return JsonUtils.createJsonBean(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,e.getMessage());
        }
    }
}
