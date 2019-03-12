package com.website.springmvc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class LoginController {
	
	@Autowired
	SessionLocaleResolver localeResolver;
	
	@RequestMapping(value = "/views/", method = RequestMethod.GET)
	public String onload(@RequestParam(value="lang", defaultValue="en") String language) {
		switch (language) {
		case "en":
			localeResolver.setDefaultLocale(Locale.ENGLISH);
			break;
		case "vi":
			localeResolver.setDefaultLocale(new Locale("vi", "VN"));
			break;
		default:
			break;
		}
		
		return "login";
	}

	@RequestMapping(value = "/views/login", method = RequestMethod.POST)
	public String login(@RequestParam String userName, @RequestParam String password) {
		if ("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password))
			return "redirect:/views/home/" + userName;
		return "login";
	}
}