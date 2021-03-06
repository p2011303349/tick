package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.SysCourse;
import com.qianfeng.entity.SysGrade;
import com.qianfeng.service.CourseService;
import com.qianfeng.service.GradeService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VGrade;
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
 * Created by Administrator on 2019/4/15 0015.
 */
@Controller
@ResponseBody
public class GradeController {

    @Autowired
    private GradeService gradeService;
    @RequestMapping("/gradepage.do")

    public Map<String, Object> gradeList(int page){
        PageHelper.startPage(page, 5);
        Map<String, Object> map = new HashMap<>();

        try {
            List<VGrade> list =  gradeService.gradeList();
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

    @RequestMapping("/gradedelete.do")

    public JsonBean deleteGrade(Integer id){
        gradeService.deleteGrade(id);
        return JsonUtils.createJsonBean(1, null);
    }

    @RequestMapping("/gradeupdate.do")
    public void updateGrade(SysGrade sysGrade, HttpServletRequest request, HttpServletResponse response){
        try {
            gradeService.updateGrade(sysGrade);

            response.sendRedirect(request.getContextPath() + "/gradelist.html");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/courseall.do")

    public List<SysCourse> courseall(){




        List<SysCourse> list =  gradeService.courseall();
            /*response.sendRedirect(request.getContextPath() + "/index.html");*/
        return list;

    }

    @RequestMapping("/gradeadd.do")

    public JsonBean gradeadd(SysGrade sysGrade, HttpServletRequest request, HttpServletResponse response){

        try {
            gradeService.gradeadd(sysGrade);
            response.sendRedirect(request.getContextPath() + "/gradelist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonUtils.createJsonBean(1, null);
    }
}
