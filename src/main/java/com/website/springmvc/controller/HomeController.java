package com.website.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/views/home")
public class HomeController {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ModelAndView printWelcome(@PathVariable("name") String name) {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("name", name);
		return model;
	}
}