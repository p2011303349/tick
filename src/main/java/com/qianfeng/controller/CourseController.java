package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.dao.SysCourseMapper;
import com.qianfeng.entity.SysCourse;
import com.qianfeng.entity.SysStudent;
import com.qianfeng.service.CourseService;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/13 0013.
 */
@Controller
@ResponseBody
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/coursepage.do")

    public Map<String, Object> courseList(int page){
        PageHelper.startPage(page, 5);
        Map<String, Object> map = new HashMap<>();

        try {
            List<SysCourse> list =  courseService.courseList();
            long total = ((Page)list).getTotal();
            /*response.sendRedirect(request.getContextPath() + "/index.html");*/
             System.out.println("sdfsfd");
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

    @RequestMapping("/coursedelete.do")

    public JsonBean deleteCourse(Integer id){
        courseService.deleteCourse(id);
        return JsonUtils.createJsonBean(1, null);
    }

    @RequestMapping("/courseupdate.do")
    public void updateCourse(SysCourse sysCourse,HttpServletRequest request, HttpServletResponse response){
        try {
            courseService.updateCourse(sysCourse);

            response.sendRedirect(request.getContextPath() + "/courselist.html");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/courseadd.do")

    public JsonBean courseadd(SysCourse sysCourse, HttpServletRequest request, HttpServletResponse response){

        try {
            courseService.courseadd(sysCourse);
            response.sendRedirect(request.getContextPath() + "/courselist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonUtils.createJsonBean(1, null);
    }


}
