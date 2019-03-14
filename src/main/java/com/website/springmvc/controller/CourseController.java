package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Course;
import com.website.springmvc.service.CourseService;

@Controller
@RequestMapping(value = "/controller")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/courses", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getAll() {
		ModelAndView model = new ModelAndView();

		model.setViewName("courseList");
		model.addObject("courses", courseService.getAll());

		return model;
	}	
	
	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course course){
		if(course.getId() == null){
			courseService.add(course);
		}
		else{
			courseService.update(course);
		}
		return "redirect:/controller/courses";
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public ModelAndView addCourse(){
		ModelAndView model = new ModelAndView();
		
		model.setViewName("courseDetail");
		model.addObject("course",new Course());
		model.addObject("mode", "EDIT");
		
		return model;
	}
	
}
