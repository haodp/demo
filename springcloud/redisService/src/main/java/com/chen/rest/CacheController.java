package com.chen.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chen.entity.User;
import com.chen.service.RedisService;

@RestController
@RequestMapping(value = "/cache")
public class CacheController {

	@Autowired
	RedisService redisService;

	// http://localhost:8888/cache/setUserList
	@RequestMapping(value = "/setUserList")
	public List<User> setUserList(HttpServletRequest request) {
		List<User> userList = new ArrayList<User>();
		redisService.setValue("name", "haichen");
		User user1 = new User();
		user1.setId(1);
		user1.setName("老王");
		user1.setAge(28);
		User user2 = new User();
		user2.setId(2);
		user2.setName("老李");
		user2.setAge(38);
		User user3 = new User();
		user3.setId(3);
		user3.setName("老趙");
		user3.setAge(48);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		redisService.setValue("userList", userList);
		return userList;
	}

	@RequestMapping(value = "/getUserList")
	public List<User> getUserList(HttpServletRequest request) {
		List<User> userList =(List<User>) redisService.getValue("userList");
		return userList;
	}
}
