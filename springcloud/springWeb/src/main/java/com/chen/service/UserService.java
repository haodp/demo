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
	final String SERVICE_NAME = "redisService";
	
	 @HystrixCommand(fallbackMethod = "fallbackGetUserList")
	    public List<User> getUserList() {
	        return restTemplate.getForObject("http://" + SERVICE_NAME + "/cache/getUserList", List.class);
	        //return feignUserService.readUserInfo();
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
