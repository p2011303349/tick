package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.CheckMapper;
import com.qianfeng.entity.Check;
import com.qianfeng.entity.User;
import com.qianfeng.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CheckMapper checkDao;
    @Override
    public Map<String,Object> findCheckAll(int page,int limit,String name) {
        PageHelper.startPage(page,limit);
        List<Check> list = checkDao.findCheckAll(name);
        // 获取总条数
        long total = ((Page)list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("count", total);// 总条数
        map.put("data", list); // 当前页显示的记录
        map.put("code",0);
        return map;
    }

    @Override
    public int insertSelective(Check record) {
        checkDao.insertSelective(record);
        return 0;
    }

    @Override
    public List<User> findRanme(String name) {
        List<User> list = checkDao.findRanme(name);
        return list;
    }

    @Override
    public void del(int id) {
        checkDao.del(id);
    }

    @Override
    public Map<String, Object> findCheckAll1(int page, int limit, String name) {
        PageHelper.startPage(page,limit);
        List<Check> list = checkDao.findCheckAll1(name);
        // 获取总条数
        long total = ((Page)list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("count", total);// 总条数
        map.put("data", list); // 当前页显示的记录
        map.put("code",0);
        return map;
    }

    @Override
    public void updateFalg(int id, int flag) {
        checkDao.updateFalg(id,flag);
    }
}
