package com.qianfeng.service;

import com.qianfeng.entity.SysDepart;
import com.qianfeng.entity.SysStaff;

import java.util.List;

/**
 * Created by Administrator on 2019/4/16 0016.
 */
public interface StaffService {
    public List<SysStaff> staffList();

    public void deleteStaff(String no);

    public List<SysDepart> departall();

    public void updateStaff(SysStaff sysStaff);
}
