package com.qianfeng.dao;

import com.qianfeng.entity.SysGrade;
import com.qianfeng.entity.SysStudent;
import com.qianfeng.vo.VStudent;

import java.util.List;

public interface SysStudentMapper {
    int deleteByPrimaryKey(String no);

    int insert(SysStudent record);

    int insertSelective(SysStudent record);

    SysStudent selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(SysStudent record);

    int updateByPrimaryKey(SysStudent record);

    public List<VStudent> studentList();

    public void deleteStudent(String no);

    public List<SysGrade> gradeall();

    public void studentadd(SysStudent sysStudent);

    public void addBatch(List<SysStudent> tempList);

    /*public void studentadd(Student vStudent);*/
}