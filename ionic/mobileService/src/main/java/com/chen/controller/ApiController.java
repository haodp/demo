package com.chen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chen.request.UserReq;
import com.chen.response.OrderRes;

@RestController
public class ApiController {

	@RequestMapping("/getOrderList")
	public List<OrderRes> getOrderList(HttpServletRequest request, HttpServletResponse resp,@RequestBody UserReq user) {
		//check token
		System.out.println("----------getOrderList----------"+user.getToken());
		List<OrderRes> orderList = new ArrayList<OrderRes>();
/*		if (user != null) {
			if (user.getId() == 1) {*/
				//invoke service
			OrderRes vo = new OrderRes();
				vo.setOrderNo("34894473848483");
				vo.setOrderName("饺子");
				vo.setOrderAddr("大有田园");
				vo.setOrderPic("http://ww3.sinaimg.cn/mw690/ae1ea35cgw1fblufyqsp5j20gk0m8gok.jpg");
				OrderRes vo1 = new OrderRes();
				BeanUtils.copyProperties(vo, vo1);
				vo1.setOrderPic("http://ww3.sinaimg.cn/large/6adf0530jw1dt67nyglvwj.jpg");
				vo1.setOrderName("包子");
				vo1.setOrderAddr("高新园区");
				vo1.setOrderNo("34894473848496");
				OrderRes vo2 = new OrderRes();
				BeanUtils.copyProperties(vo, vo2);
				vo2.setOrderPic("http://ww3.sinaimg.cn/large/6e48db9egw1f9hmbgxhcyj20ku0mp412.jpg");
				vo2.setOrderName("面条");
				vo2.setOrderAddr("沙河口区");
				vo2.setOrderNo("34894473848499");
				orderList.add(vo2);
				orderList.add(vo1);
				orderList.add(vo);
/*			}

		}*/

		return orderList;
	}
}
