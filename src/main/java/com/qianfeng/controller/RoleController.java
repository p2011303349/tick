package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.service.RoleService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/rolepage.do")
    @ResponseBody
    public Map<String,Object> findUserAll(int page, int limit, String no, Integer flag){
        Map<String, Object> map = roleService.findUserAll(page,limit, no, flag);
        return map;
    }

    @RequestMapping("/roledel.do")
    @ResponseBody
    public JsonBean findRoleDel(int id){
        roleService.delById(id);
        return JsonUtils.createJsonBean(1,null);
    }


}
