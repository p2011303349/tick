package com.qianfeng.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.utils.JsonUtils;

// 统一处理异常
// 控制器没有处理的异常，会被该类接收进行处理
@ControllerAdvice
@ResponseBody
public class CommonException {

	
	@ExceptionHandler(Exception.class)
	public JsonBean commonException(Exception e){
		System.out.println( e.getMessage());
		return JsonUtils.createJsonBean(0, e.getMessage());

	}
}
