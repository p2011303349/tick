package com.qianfeng.service.impl;

import com.qianfeng.dao.SysCourseMapper;
import com.qianfeng.dao.SysStaffMapper;
import com.qianfeng.entity.SysDepart;
import com.qianfeng.entity.SysStaff;
import com.qianfeng.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/16 0016.
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private SysStaffMapper staffDao;
    @Override
    public List<SysStaff> staffList() {
        return staffDao.staffList();
    }

    @Override
    public void deleteStaff(String no) {
        staffDao.deleteStaff(no);
    }

    @Override
    public List<SysDepart> departall() {

        return staffDao.departall();
    }

    @Override
    public void updateStaff(SysStaff sysStaff) {
        staffDao.updateStaff(sysStaff);
    }

    @Override
    public void addStaff(SysStaff sysStaff) {
        staffDao.addStaff(sysStaff);
    }
    @Override
    public void addUserBatch(List<SysStaff> list) {
        int count  = 1 ;
        List<SysStaff> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tempList.add(list.get(i));
            if(count % 100 != 0) {
                count++;
            }else {
                staffDao.addBatch(tempList);
                tempList.clear();
                count = 1;
            }

        }
        //最后的少于100条无法添加的处理
        if (tempList.size() != 0) {
            staffDao.addBatch(tempList);
        }
    }


}
