package com.website.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping(value = "/views/", method = RequestMethod.GET)
	public String onload() {
		return "login";
	}

	@RequestMapping(value = "/views/login", method = RequestMethod.POST)
	public String login(@RequestParam String userName, @RequestParam String password) {
		if ("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password))
			return "redirect:/views/course/";
		return "login";
	}
}