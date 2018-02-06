package com.chen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chen.entity.User;
/**
 * @author haichen 
 *
 */
@RestController
public class ApiController {

	// http://localhost:9999/mvvmweb/getUserList
	@RequestMapping("/getUserList")
	public List<User> getUserList(HttpServletRequest req, HttpServletResponse resp) {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId(i);
			user.setAge(10 + i);
			user.setName("haichen" + i);
			list.add(user);
		}
		return list;

	}
}
