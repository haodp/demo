package com.chen.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

public class WeixinUtil {
	private static final Logger log = Logger.getLogger(WeixinUtil.class);

	public static String getSignature(String token, String timestamp, String nonce) {
		StringBuilder signatureBuilder = new StringBuilder();
		try {
			ArrayList<String> paramList = new ArrayList<String>();
			paramList.add(token);
			paramList.add(timestamp);
			paramList.add(nonce);
			Collections.sort(paramList);
			StringBuilder stringBuilder = new StringBuilder();
			for (String param : paramList) {
				stringBuilder.append(param);
			}
			MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
			sha1Digest.update(stringBuilder.toString().getBytes());
			byte[] digest = sha1Digest.digest();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					signatureBuilder.append(0);
				}
				signatureBuilder.append(shaHex);
			}

		} catch (Exception e) {
			log.error("WeixinUtil: getSignature: hit exception:" + e);
		}
		return signatureBuilder.toString();
	}

	public static String getAccessToken() {
		String accessToken = "";
		// read from cache
		// accessToken = redisService.get(WeixinConstant.CACHE_ACCESS_TOKEN);
		if (StringUtils.isEmpty(accessToken)) {
			accessToken = getAccessTokenFromWeixin();
		}

		return accessToken;

	}

	public static String getAccessTokenFromWeixin() {
		String url = WeixinConstant.ACCESS_TOKEN_URL + "&appid=" + WeixinConstant.APP_ID + "&secret="
				+ WeixinConstant.APP_SECRET;
		String result = HttpUtil.get(url);
		System.out.println("---------result-----------" + result);
		JSONObject obj = new JSONObject(result);
		String access_token = obj.getString("access_token");
		int expires = obj.getInt("expires_in");
		if (null == access_token || "".equals(access_token)) {
			throw new RuntimeException(result);
		}

		// set to cache
		// redisService.set(WeixinConstant.CACHE_ACCESS_TOKEN, access_token,
		// 3600);
		return access_token;
	}

	public static String createMenu(String json) {
		String url = WeixinConstant.MENU_CREATE_URL + getAccessToken();
		String result = HttpUtil.post(url, json);
		// set to cache
		// redisService.set(WeixinConstant.CACHE_ACCESS_TOKEN, access_token,
		// 3600);
		return result;
	}

	public static String getOpenidBycode(String code) {
		String url = String.format(WeixinConstant.USER_INFO_ACCESS_TOKEN_URL, WeixinConstant.APP_ID,
				WeixinConstant.APP_SECRET, code);
		System.out.println("------getOpenidBycode----url-------------------:" + url);

		String result = HttpUtil.get(url);
		JSONObject obj = new JSONObject(result);
		String access_token = obj.getString("access_token");
		String openid = obj.getString("openid");
		System.out.println("------getOpenidBycode----access_token-------------------:" + access_token);
		System.out.println("------getOpenidBycode----openid-------------------:" + openid);
		if (null == access_token || "".equals(access_token)) {
			throw new RuntimeException(result);
		}
		return openid;
	}

}
