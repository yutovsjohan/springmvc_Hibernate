package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Course;
import com.website.springmvc.service.CourseService;

@Controller
@RequestMapping(value = "/views/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getAll() {
		ModelAndView model = new ModelAndView();

		model.setViewName("courseList");
		model.addObject("courses", courseService.getAll());

		return model;
	}	
}
