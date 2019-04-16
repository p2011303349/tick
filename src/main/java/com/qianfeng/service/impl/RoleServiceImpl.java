package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.RoleMapper;
import com.qianfeng.dao.UserMapper;
import com.qianfeng.entity.Role;
import com.qianfeng.service.RoleService;
import com.qianfeng.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
@Controller
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleDao;

    @Override
    public Map<String, Object> findUserAll(int page, int limit, String no, Integer flag) {
        PageHelper.startPage(page,limit);
        List<Role> list = roleDao.findRoleAll(no,flag);
        // 获取总条数
        long total = ((Page)list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("count", total);// 总条数
        map.put("data", list); // 当前页显示的记录
        map.put("code",0);
        map.put("mag","");
        return map;
    }

    @Override
    public void delById(int id) {
        int flag = 2;
        roleDao.delById(flag,id);
        roleDao.delByRId(flag,id);
    }
}
