package com.qianfeng.service;

import com.qianfeng.entity.SysDepart;
import com.qianfeng.vo.VSysDepart;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/17.
 */
public interface DeptService {
    public Map<String,Object> selectDeptAll(int page, int limit);

    public void deleteDept(int id);

    public int updateByPrimaryKeySelective(SysDepart record);

    public void  insertdept(SysDepart record);


}
