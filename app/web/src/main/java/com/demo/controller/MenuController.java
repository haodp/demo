package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.demo.common.constants.FwConstants;
import com.demo.model.LoginOutputModel;
import com.demo.model.TreeJsonModel;
import com.demo.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MenuController {

	@Autowired
	private MenuService service;

	@Autowired
	private HttpServletRequest request;


	@RequestMapping("/menu")
	public String init() {

		LoginOutputModel user = (LoginOutputModel)request.getSession().getAttribute(FwConstants.SESSION_KEY_LOGININFO);

		List<TreeJsonModel> model = service.init(user.getId().toString());
		request.getSession().setAttribute(FwConstants.SESSION_KEY_MENUINFO, JSON.toJSON(model));
		return "menu";
	}
}
