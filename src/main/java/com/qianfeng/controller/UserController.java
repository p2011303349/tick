package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/14.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/userall.do")
    @ResponseBody
    public Map<String,Object> findUserAll(int page,int limit,String no,Integer flag){
        Map<String, Object> map = userService.findUserAll(page,limit, no, flag);
        map.put("code",0);
        map.put("mag","");
        return map;
    }
    @RequestMapping("/userdel.do")
    @ResponseBody
    public JsonBean findUserDel(int id){
        userService.delById(id);
        return JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/roleall.do")
    @ResponseBody
    public List<VUser> findRole(int id){
        List<VUser> list = userService.findrole(id);
        return list;
    }

    @RequestMapping("/userroleedit.do")
    @ResponseBody
    public JsonBean updateStatus(int id,Integer rids,String name){
        int k;
        if (rids == null){
            k = 2;
        }else {
           k = 1;
        }
        userService.updateStatus(id,k,name);
        return JsonUtils.createJsonBean(1,null);
    }


}
