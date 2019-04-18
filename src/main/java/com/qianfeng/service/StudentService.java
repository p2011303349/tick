package com.qianfeng.service;

import com.qianfeng.entity.SysCourse;
import com.qianfeng.entity.SysGrade;
import com.qianfeng.entity.SysStudent;
import com.qianfeng.vo.VStudent;

import java.util.List;

/**
 * Created by Administrator on 2019/4/13 0013.
 */
public interface StudentService {
   public List<VStudent> studentList();

   public void deleteStudent(String no);

    public List<SysGrade> gradeall();

    public void studentadd(SysStudent student);

    public void addStudentBatch(List<SysStudent> list);
   /*public void deleteCourse(Integer id);

   public void updateCourse(SysCourse sysCourse);*/
}
