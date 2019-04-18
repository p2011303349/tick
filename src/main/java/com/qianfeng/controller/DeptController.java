package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.SysDepart;
import com.qianfeng.service.DeptService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/17.
 */

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("/departpagelist.do")
    public Map<String,Object> selectDeptAll(int page,int limit){
        Map<String, Object> map = deptService.selectDeptAll(page, limit);
        return  map;
    }

    @RequestMapping("/departdelete.do")
    public JsonBean deletetDept(int id){
        deptService.deleteDept(id);
        return JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/departupdate.do")
    public JsonBean updateDept(SysDepart dept, HttpServletRequest request, HttpServletResponse response){
        deptService.updateByPrimaryKeySelective(dept);
        try {
            response.sendRedirect(request.getContextPath() + "/departlist.html");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/departadd.do")
    public void addDept(SysDepart dept, HttpServletRequest request, HttpServletResponse response){
        deptService.insertdept(dept);
        try {
            response.sendRedirect(request.getContextPath() + "/departlist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
