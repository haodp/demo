package com.demo.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.LoginOutputModel;
import com.demo.service.LoginService;

import lombok.extern.slf4j.Slf4j;


/**
 * restful风格的JSON的做成。这个例子。如果有问题，请联系
 * 注意必须添加.json这个关键字
 * @author Administrator
 *
 */
@Slf4j
@Controller
@RequestMapping(value="/R001S001.json")
public class R001S001Controller {

	@Autowired
	LoginService service;

	@RequestMapping("/init")
	@ResponseBody
	public LoginOutputModel init() throws IllegalAccessException, InvocationTargetException {
		LoginOutputModel model = service.doLogin("1", "2ce0a961104651a4d186460a7fbf7b5247001340");
		log.info(model.toString());
		return model;
	}
}
