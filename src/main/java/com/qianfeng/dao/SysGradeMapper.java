package com.qianfeng.dao;

import com.qianfeng.entity.SysCourse;
import com.qianfeng.entity.SysGrade;
import com.qianfeng.vo.VGrade;

import java.util.List;

public interface SysGradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysGrade record);

    int insertSelective(SysGrade record);

    SysGrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysGrade record);

    int updateByPrimaryKey(SysGrade record);



    public List<VGrade> gradeList();

    public void deleteGrade(Integer id);

    public void updateGrade(SysGrade sysGrade);

    public void gradeadd(SysGrade sysGrade);

    public List<SysCourse> courseall();
}