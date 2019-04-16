package com.qianfeng.service;

import com.qianfeng.entity.SysCourse;

import java.util.List;

/**
 * Created by Administrator on 2019/4/13 0013.
 */
public interface CourseService {
   public List<SysCourse> courseList();
   public void deleteCourse(Integer id);

   public void updateCourse(SysCourse sysCourse);
}
