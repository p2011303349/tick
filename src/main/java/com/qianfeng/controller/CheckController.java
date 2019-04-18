package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Check;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;
import com.qianfeng.service.CheckService;
import com.qianfeng.service.RoleService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
@RestController
public class CheckController {
    @Autowired
    private CheckService checkService;
    @Autowired
    private RoleService roleService;
    @RequestMapping("/processlist.do")
    public Map<String,Object> findUserAll(int page, int limit, HttpSession session){
        User user = (User) session.getAttribute(CommonInfo.LOGIN_USER);
        Map<String, Object> map = checkService.findCheckAll(page,limit,user.getNo());
        return map;
    }

    @RequestMapping("/processadd.do")
    public void  addCheck(Check check, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User user = (User) session.getAttribute(CommonInfo.LOGIN_USER);
        check.setStartname(user.getName());
        check.setStartno(user.getNo());
        check.setFlag(2);
        check.setPid (String.valueOf((int)(Math.random()*1000+100)));
        checkService.insertSelective(check);
        try {
            response.sendRedirect(request.getContextPath() + "/processlist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/departall1.do")
    public  Collection<User> findRole(HttpSession session){
        User user = (User) session.getAttribute(CommonInfo.LOGIN_USER);
        Collection<User> role1 = roleService.findRole1(user.getId());
        return role1;
    }


    @RequestMapping("/processdel.do")
    public JsonBean del(int id){
        checkService.del(id);
        return JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/processtodolist.do")
    public Map<String,Object> findProcess(int page, int limit, HttpSession session){
        User user = (User) session.getAttribute(CommonInfo.LOGIN_USER);
        Map<String, Object> map = checkService.findCheckAll1(page,limit,user.getName());
        return map;
    }


    @RequestMapping("/processupdate.do")
    public JsonBean updateProcsee(int id,int flag){
        checkService.updateFalg(id,flag);
        return JsonUtils.createJsonBean(1,null);
    }










}
