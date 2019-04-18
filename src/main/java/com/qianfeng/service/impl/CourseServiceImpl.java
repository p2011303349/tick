package com.qianfeng.service.impl;

import com.qianfeng.dao.SysCourseMapper;
import com.qianfeng.dao.UserMapper;
import com.qianfeng.entity.SysCourse;
import com.qianfeng.service.CourseService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/13 0013.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private SysCourseMapper courseDao;
    @Override
    public List<SysCourse> courseList() {

        return courseDao.courseList();
    }

    @Override
    public void deleteCourse(Integer id) {
        courseDao.deleteCourse(id);
    }

    @Override
    public void updateCourse(SysCourse sysCourse) {
        courseDao.updateCourse(sysCourse);
    }

    @Override
    public void courseadd(SysCourse sysCourse) {
        courseDao.courseadd(sysCourse);
    }
}
