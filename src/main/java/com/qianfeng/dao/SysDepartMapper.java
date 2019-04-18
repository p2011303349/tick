package com.qianfeng.dao;

import com.qianfeng.entity.SysDepart;
import com.qianfeng.vo.VSysDepart;

import java.util.List;

public interface SysDepartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDepart record);

    int insertSelective(SysDepart record);

    SysDepart selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(SysDepart record);

    int updateByPrimaryKey(SysDepart record);

    public List<VSysDepart> selectDeptAll();

    public void deleteDeptStff(int did);

    public void deleteDept(int id);

    public void  insertdept(SysDepart record);

}