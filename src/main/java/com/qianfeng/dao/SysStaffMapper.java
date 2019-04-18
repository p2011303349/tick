package com.qianfeng.dao;

import com.qianfeng.entity.SysDepart;
import com.qianfeng.entity.SysStaff;

import java.util.List;

public interface SysStaffMapper {
    int deleteByPrimaryKey(String no);

    int insert(SysStaff record);

    int insertSelective(SysStaff record);

    SysStaff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(SysStaff record);

    int updateByPrimaryKey(SysStaff record);

    public List<SysStaff> staffList();

    public void deleteStaff(String no);

    public List<SysDepart> departall();

    public void updateStaff(SysStaff sysStaff);

    public void addStaff(SysStaff sysStaff);

    public void addBatch(List<SysStaff> list);
}