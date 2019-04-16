package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.AuthorityMapper;
import com.qianfeng.entity.Authority;
import com.qianfeng.entity.Role;
import com.qianfeng.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService{
    @Autowired
    private AuthorityMapper authorityDao;
    @Override
    public Map<String, Object> findAuthorityAll(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Authority> list = authorityDao.findAuthorityAll();
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
    public List findAu(int id) {
        List ll = new ArrayList();
        List<Authority> li = authorityDao.findAu(id);
        List<Authority> all = authorityDao.findAll();
        ll.add(li);
        ll.add(all);
        return ll;
    }
}
