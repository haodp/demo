package com.chen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.entity.User;
import com.chen.service.UserService;

@Controller
public class HomePageController {
	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public String login(HttpServletRequest request,Model model) {
		List<User> userList = userService.getUserList();
		System.out.println("======userList======" + userList);
		model.addAttribute("userList", userList);
		return "index";
	}

}
