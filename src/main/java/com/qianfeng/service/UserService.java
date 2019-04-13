package com.qianfeng.service;

/**
 * Created by Administrator on 2019/4/13.
 */
public interface UserService {
    public String findPwdByName(String name);
    public void login(String name, String password);
}
