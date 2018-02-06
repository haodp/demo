package com.chen.util;

public class WeixinConstant {
	public static final String APP_ID = "wx9daa8a75c5c73901";
	public static final String APP_SECRET = "d2e0b1ed4b78337a1d70fc85838131eb";
	public static final String TOKEN = "haichen";
	public static final String CACHE_ACCESS_TOKEN = "cacheAccessToken";
	// 获得Access Token
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	public static final String WEIXIN_CONNECT_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=%s#wechat_redirect";
	public static final String WEIXIN_CONNECT_AUTHORIZE_STATE = "HaichenState";
	public static final String USER_INFO_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
}
