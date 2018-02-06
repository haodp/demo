package com.chen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.chen.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;
	private final String SERVICE_NAME = "redisService";
	private final String GATEWAY_HOST = "gateway";
	private final String GATEWAY_SERVICE_NAME = "redis";

	@HystrixCommand(fallbackMethod = "fallbackGetUserList")
	public List<User> getUserList() {
		//网关调用地址: http://localhost:5555/redis/cache/getUserList  或  http://gateway/redis/cache/getUserList
		return restTemplate.getForObject("http://" + GATEWAY_HOST +"/" +GATEWAY_SERVICE_NAME + "/cache/getUserList",
				List.class);
		//注册中心调用地址: http://redisService/cache/getUserList
		//return restTemplate.getForObject("http://" + SERVICE_NAME + "/cache/getUserList",
		//		List.class);
	}

	private List<User> fallbackGetUserList() {
		System.out.println("get failed!!");
		List<User> ls = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("haichen");
		ls.add(user);
		return ls;
	}

}
