package com.qianfeng.service.impl;

import com.qianfeng.dao.UserMapper;
import com.qianfeng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/4/13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userDao;
    @Override
    public String findPwdByName(String name) {

        return userDao.findPwdByName(name);
    }

    @Override
    public void login(String name, String password) {
        // shiro中提供的认证操作方法
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        // 设置超时时间
        subject.getSession().setTimeout(30 * 60);
        subject.login(token);
    }
}
