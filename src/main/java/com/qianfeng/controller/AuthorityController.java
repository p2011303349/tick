package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Authority;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
@Controller
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/authoritylist.do")
    @ResponseBody
    public Map<String,Object> findAuthorityAll(int page, int limit){
        Map<String, Object> map = authorityService.findAuthorityAll(page,limit);
        return map;
    }
    @RequestMapping("/auall.do")
    @ResponseBody
    public List findAu(int id){
        List list = authorityService.findAu(id);
        return list;
    }
}
