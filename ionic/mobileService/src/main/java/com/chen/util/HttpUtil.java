package com.chen.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String get(String url) {
		String responseContent = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(httpGet);
			responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
			System.out.println("--------get---responseContent-----------" + responseContent);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseContent;
	}

	public static String post(String url, String jsonStr) {
		String responseContent = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(jsonStr, Charset.forName("UTF-8")));
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(httpPost);
			responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
			System.out.println("--------post---responseContent-----------" + responseContent);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseContent;
	}
}
