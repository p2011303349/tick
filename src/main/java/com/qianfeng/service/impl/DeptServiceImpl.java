package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.SysDepartMapper;
import com.qianfeng.entity.SysDepart;
import com.qianfeng.service.DeptService;
import com.qianfeng.vo.VSysDepart;
import com.qianfeng.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/17.
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private SysDepartMapper deptDao;
    @Override
    public Map<String, Object> selectDeptAll(int page,int limit) {
        PageHelper.startPage(page,limit);
        List<VSysDepart> list = deptDao.selectDeptAll();
        // 获取总条数
        long total = ((Page)list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("count", total);// 总条数
        map.put("data", list); // 当前页显示的记录
        map.put("code",0);
        return map;
    }

    @Override
    public void deleteDept(int id) {
        deptDao.deleteDept(id);
        deptDao.deleteDeptStff(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDepart record) {
        deptDao.updateByPrimaryKeySelective(record);
        return 0;
    }

    @Override
    public void insertdept(SysDepart record) {
        deptDao.insertdept(record);
    }
}
