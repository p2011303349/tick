package com.qianfeng.service.impl;

import com.qianfeng.dao.SysCourseMapper;
import com.qianfeng.dao.SysStudentMapper;
import com.qianfeng.entity.SysCourse;
import com.qianfeng.entity.SysGrade;
import com.qianfeng.entity.SysStudent;
import com.qianfeng.service.CourseService;
import com.qianfeng.service.StudentService;
import com.qianfeng.vo.VStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/13 0013.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private SysStudentMapper studentDao;

    @Override
    public List<VStudent> studentList() {
        List<VStudent> sysStudents = studentDao.studentList();
        return sysStudents;
    }

    @Override
    public void deleteStudent(String no) {
        studentDao.deleteStudent(no);
    }

    @Override
    public List<SysGrade> gradeall() {
        List<SysGrade> sysStudents = studentDao.gradeall();

        return sysStudents;
    }

    @Override
    public void studentadd(SysStudent sysStudent) {
        studentDao.studentadd(sysStudent);
    }

    @Override
    public void addStudentBatch(List<SysStudent> list) {
        // TODO Auto-generated method stub
        // 每100条记录，进行一次批量操作
        int count = 1;
        List<SysStudent> tempList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){

            tempList.add(list.get(i));
            if(count % 100 != 0){
                count++;
            }else{
                studentDao.addBatch(tempList);
                tempList.clear();
                count = 1;
            }

        }
        if(tempList.size() != 0){
            studentDao.addBatch(tempList);
        }

    }


}
