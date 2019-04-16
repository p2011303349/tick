package com.qianfeng.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;

import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VMenuInfo;


@Controller
public class MenuController {
	@Autowired
	private UserService userService;
	@RequestMapping("/usermenu.do")
	@ResponseBody
	public JsonBean findMenu(HttpSession session){
		User user = (User) session.getAttribute(CommonInfo.LOGIN_USER);
		List<VMenuInfo> list = userService.findMenu(user.getNo());
		return JsonUtils.createJsonBean(1,list);
	}

}




