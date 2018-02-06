package com.chen.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chen.util.HttpUtil;
import com.chen.util.WeixinConstant;
import com.chen.util.WeixinUtil;

@RestController
public class WeixinController {

	private static final Logger log = Logger.getLogger(WeixinController.class);

	// 微信接入验证接口
	// http://localhost:8080/mobile/weixinConnect
	// http://5ileslie.com/mobile/weixinConnect
	@RequestMapping("/weixinConnect")
	public String weixinConnect(HttpServletRequest request, HttpServletResponse response)
			throws NoSuchAlgorithmException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		log.info("WeixinController: weixinConnect: signature:[" + signature + "],timestamp:[" + timestamp
				+ "],echostr:[" + echostr + "],nonce:[" + nonce + "]");
		String tempSignature = WeixinUtil.getSignature(WeixinConstant.TOKEN, timestamp, nonce);
		if (signature.equals(tempSignature)) {
			return echostr;
		}

		return "";
	}

	// 获取access_token
	// http://5ileslie.com/mobile/weixinGetAccessToken
	@RequestMapping("/weixinGetAccessToken")
	public String weixinGetAccessToken(HttpServletRequest request, HttpServletResponse response)
			throws NoSuchAlgorithmException {
		String accessToken = WeixinUtil.getAccessToken();
		System.out.println("--------accessToken---------" + accessToken);

		return accessToken;
	}

	// http://5ileslie.com/mobile/weixincreateMenu
	@RequestMapping("/weixincreateMenu")
	public String weixincreateMenu(HttpServletRequest request, HttpServletResponse response)
			throws NoSuchAlgorithmException {
		String jsonStr = readFile();

		System.out.println("----------jsonStr-------------------" + jsonStr);
		WeixinUtil.createMenu(jsonStr);

		return "ok";
	}

	// 需要配置[网页授权获取用户基本信息]权限中设置回调域名:5ileslie.com
	// http://5ileslie.com/mobile/weixinMenucontact
	@RequestMapping("/weixinMenucontact")
	public String weixinMenucontact(HttpServletRequest request, HttpServletResponse response)
			throws NoSuchAlgorithmException {
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		System.out.println("------weixinMenucontact----code-------------------:" + code + ",state:" + state);
		if (code != null) {
			String openid = WeixinUtil.getOpenidBycode(code);
			return "你的openid是：" + openid;
		}

		return "哈哈哈 被骗了";
	}

	// 同上 需要配置[网页授权获取用户基本信息]权限中设置回调域名:5ileslie.com
	// http://5ileslie.com/mobile/weixinMenu1024
	@RequestMapping("/weixinMenu1024")
	public String weixinMenu1024(HttpServletRequest request, HttpServletResponse response)
			throws NoSuchAlgorithmException {
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		System.out.println("------weixinMenucontact----code-------------------:" + code + ",state:" + state);
		if (code != null) {
			String openid = WeixinUtil.getOpenidBycode(code);
			return "你的openid是：" + openid;
		}

		return "哈哈哈 又被骗了";
	}
	
	
	public String readFile() {
		// File file = ResourceUtils.getFile("classpath*:/static/menu.json");
		// Resource fileRource = new ClassPathResource("/static/menu.json");
		InputStream inputStream = this.getClass().getResourceAsStream("/static/menu.json");
		String jsonStr = "";
		try {
			jsonStr = IOUtils.toString(inputStream, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * File file = null; try { file = fileRource.getFile(); } catch
		 * (IOException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		// File file = new File(fileName);
		/*
		 * try { jsonStr = FileUtils.readFileToString(file); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		return jsonStr;
	}
}
