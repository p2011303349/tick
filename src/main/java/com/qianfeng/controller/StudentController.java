package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.SysCourse;
import com.qianfeng.entity.SysGrade;
import com.qianfeng.entity.SysStudent;
import com.qianfeng.service.CourseService;
import com.qianfeng.service.StudentService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/13 0013.
 */
@Controller
@ResponseBody
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/studentpage.do")

    public Map<String, Object> studentList(int page){
        PageHelper.startPage(page, 5);
        Map<String, Object> map = new HashMap<>();

        try {
            List<VStudent> list =  studentService.studentList();
            /*response.sendRedirect(request.getContextPath() + "/index.html");*/
            long total = ((Page)list).getTotal();
            map.put("code", 0); // 0 表示成功
            map.put("msg", "");
            map.put("count", total);
            map.put("data", list);

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }
    }

    @RequestMapping("/gradeall.do")

    public List<SysGrade> gradeall(){




            List<SysGrade> list =  studentService.gradeall();
            /*response.sendRedirect(request.getContextPath() + "/index.html");*/
            return list;

    }

    @RequestMapping("/studentdelete.do")

    public JsonBean deleteStudent(String no){
        studentService.deleteStudent(no);
        return JsonUtils.createJsonBean(1, null);
    }

    @RequestMapping("/studentadd.do")

    public JsonBean studentadd(SysStudent sysStudent,HttpServletRequest request, HttpServletResponse response){

        try {
            studentService.studentadd(sysStudent);
            response.sendRedirect(request.getContextPath() + "/studentlist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonUtils.createJsonBean(1, null);
    }

    /*@RequestMapping("/courseupdate.do")
    public void updateCourse(SysCourse sysCourse,HttpServletRequest request, HttpServletResponse response){
        try {
            courseService.updateCourse(sysCourse);

            response.sendRedirect(request.getContextPath() + "/courselist.html");
        } catch (Exception e){
            e.printStackTrace();
        }
    }*/


}
