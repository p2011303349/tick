package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public void login(String no, String pass, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        try {
            userService.login(no, pass);
            User user = userService.findByNo(no);
            session.setAttribute(CommonInfo.LOGIN_USER,user);
            response.sendRedirect(request.getContextPath() + "/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
