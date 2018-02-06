package com.demo.common.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.demo.common.constants.FwConstants;
import com.demo.common.json.CustomObjectMapper;
import com.demo.common.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Session 校验 ACLInterceptor<br>
 */
public class ACLInterceptor implements HandlerInterceptor {

	/** LOG */
	private static Logger log = LoggerFactory.getLogger(ACLInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// Path为JSON的场合,不进行权限以及session控制
		String servletPath = request.getServletPath();
		if (servletPath.contains(".json") || servletPath.contains("menu/init")) {
			return true;
		}

		// session中没有个人情报的情况。
		Object loginInfo = WebUtils.getSessionAttribute(request, FwConstants.SESSION_KEY_LOGININFO);

		if (loginInfo == null) {
			if ((request.getHeader("accept") != null && request.getHeader("accept").indexOf("application/json") > -1)
					|| (request.getHeader("X-Requested-With") != null
							&& request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)) {

				PrintWriter writer = null;
				ObjectMapper objectMapper = new CustomObjectMapper();

				Map<String, String> msg = new HashMap<String, String>();
				msg.put("id", "fw.e.loginTimeout");
				msg.put("content", "登录超时，请重新登录！");

				List<Map<String, String>> msgs = new ArrayList<Map<String, String>>();
				msgs.add(msg);

				Map<String, Object> resp = new HashMap<String, Object>();
				resp.put("returnCode", "9");
				resp.put("messageInfos", msgs);

				try {
					String jsonStr = objectMapper.writeValueAsString(resp);
					log.debug("ResponseContent: {}", jsonStr);

					response.setContentType("application/json;charset=UTF-8");
					writer = response.getWriter();
					writer.print(jsonStr);

				} catch (IOException e) {

					log.error("Response write failure.", e);
				} finally {
					if (writer != null) {
						writer.close();
					}
				}
				// 定时任务
			} else if (request.getRequestURI().indexOf("timetask") != -1) {
				return true;
			} else {
				String loginUrl = request.getContextPath();
				if (StringUtil.isEmpty(loginUrl)) {
					loginUrl = "/";
				}
				response.sendRedirect(loginUrl);
			}

			return false;
		}

		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.debug("######################## postHandle");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
