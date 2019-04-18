package com.qianfeng.dao;

import com.qianfeng.entity.SysCourse;

import java.util.List;

public interface SysCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysCourse record);

    int insertSelective(SysCourse record);

    SysCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysCourse record);

    int updateByPrimaryKey(SysCourse record);

    public List<SysCourse> courseList();

    public void deleteCourse(Integer id);

    public void updateCourse(SysCourse sysCourse);

    public void courseadd(SysCourse sysCourse);
}