package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.CommonInfo;
import com.qianfeng.dao.UserMapper;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.VMenuInfo;
import com.qianfeng.vo.VUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userDao;

    @Override
    public User findByNo(String name) {
        return userDao.findByNo(name);
    }

    @Override
    public void login(String name, String password) {
        // shiro中提供的认证操作方法
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();


        try {
            subject.login(token);
            //没有抛异常则登录成功
        } catch ( UnknownAccountException uae ) {
            System.out.println("用户名不存在");
        } catch ( IncorrectCredentialsException ice ) {
            System.out.println("密码错误");
        } catch ( LockedAccountException lae ) {
            System.out.println("用户被锁定，不能登录");
        }
    }

    @Override
    public List<VMenuInfo> findMenu(String no) {
        List<VMenuInfo> list = userDao.findMenu(no);
        return list;
    }

    @Override
    public Map<String, Object> findUserAll(int page,int limit, String no, Integer flag) {
        PageHelper.startPage(page,limit);
        List<VUser> list = userDao.findUserAll(no,flag);
        // 获取总条数
        long total = ((Page)list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("count", total);// 总条数
        map.put("data", list); // 当前页显示的记录

        return map;
    }

    @Override
    public void delById( int id) {
        int flag = 2;
        userDao.delById(flag,id);
    }

    @Override
    public List<VUser> findrole(Integer id) {
        List<VUser> list = userDao.findrole(id);
        return list;
    }

    @Override
    public void updateStatus(int id, int rids,String name) {
        userDao.updateStatus(rids,id);
        int id1 = userDao.findUserId(id);
        userDao.updateName(name,id1);
    }


}
