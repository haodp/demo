package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.demo.common.constants.FwConstants;
import com.demo.common.util.JsonMapper;
import com.demo.common.util.SecurityUtil;
import com.demo.model.LoginInputModel;
import com.demo.model.LoginOutputModel;
import com.demo.service.LoginService;
import com.demo.service.SysCacheService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private LoginService service;

	@Value("${crypt.key}")
	private String cryptKey;

	@Autowired
	SysCacheService cacheService;
	/**
	 * 登陆页面
	 *
	 * @return String
	 */
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	/**
	 * 用户登录
	 *
	 * @param userName
	 *            用户名
	 * @param pwd
	 *            密码
	 * @return Map<String, Object> 登录信息
	 */
	@RequestMapping("/login")
	public LoginOutputModel doLogin(@Valid LoginInputModel input, BindingResult result) {
		LoginOutputModel model = new LoginOutputModel();
//		if (StringUtils.isEmpty(userName)) {
//			model.setSuccess(false);
//			model.setErrorMessage("用户名不能为空");
//	       return model;
//		}
//		if (StringUtils.isEmpty(pwd)) {
//			model.setSuccess(false);
//			model.setErrorMessage("密码不能为空");
//			return model;
//		}

	    if(result.hasErrors()){
	    	model.setSuccess(false);
	    }

		try {
			String pwd = SecurityUtil.createSHA1(cryptKey.concat(SecurityUtil.decodeBase64(input.getPwd())));
			model = service.doLogin(input.getUserName(), pwd);

			request.getSession().setAttribute(FwConstants.SESSION_KEY_LOGININFO, model);
		} catch (Exception e) {
			log.error(e.getMessage());
			model.setSuccess(false);
			model.setErrorMessage("登陆出错，请确认是否正确。");
			return model;
		}

		return model;
	}

	/**
	 * 用户登出
	 *
	 * @return String
	 */
	@RequestMapping("/logout")
	public String logout() {
		if (request.getSession(false) != null) {
			request.getSession(false).invalidate();
		}
		return "redirect:/";
	}
}
