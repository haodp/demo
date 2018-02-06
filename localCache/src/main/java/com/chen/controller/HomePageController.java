package com.chen.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chen.entity.User;
import com.chen.service.ConCacheService;
import com.chen.service.GCacheService;
import com.chen.util.Constants;

@RestController
public class HomePageController {
    private static final Logger log = Logger.getLogger(HomePageController.class);
    @Autowired
    ConCacheService conCacheService;
    @Autowired
    GCacheService gCacheService;

    // http://localhost:9095/cache/getUser
    @RequestMapping("/getUser")
    public User getUser() {
        User user = (User) conCacheService.getCachePool().get(Constants.USER_KEY);
        if (Objects.isNull(user)) {
            user = new User();
        }

        return user;
    }

    // http://localhost:9095/cache/setUser
    @RequestMapping("/setUser")
    public User setUser() {
        User user = new User();
        user.setName("haichen");
        user.setId(1);
        user.setAge(28);
        conCacheService.getCachePool().put(Constants.USER_KEY, user);

        return user;
    }

    // http://localhost:9095/cache/getToken
    @RequestMapping("/getToken")
    public String getToken(HttpServletRequest request) {
        String token = gCacheService.getToken(Constants.TOKEN_KEY);
        log.info("-----------------------" + token);
        return token;
    }
}
