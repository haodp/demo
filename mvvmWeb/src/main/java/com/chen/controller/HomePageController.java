package com.chen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haichen 
 *
 */
@Controller
public class HomePageController {

	@RequestMapping("/vuepage")
	public String vue(HttpServletRequest request, Model model) {

		return "vuepage";
	}

	@RequestMapping("/knockoutpage")
	public String knockoutpage(HttpServletRequest request, Model model) {

		return "knockoutpage";
	}

	@RequestMapping("/angularpage")
	public String angularpage(HttpServletRequest request, Model model) {

		return "angularpage";
	}
}
