package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entity.Course;
import com.website.springmvc.service.CourseService;

@Controller
@RequestMapping(value = "/views/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept = application/json")
	public ModelAndView getCourses(ModelAndView model) {
		model.setViewName("course");
		model.addObject("course", courseService.getAll());
		return model;
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public ModelAndView addCourses(ModelAndView model) {
		model.setViewName("courseDetail");
		model.addObject("course", new Course());
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("course") Course course) throws Exception {
		if(course.getId() == null) {
			courseService.add(course);
		}
		else {
			courseService.update(course);
		}
		return "redirect:/views/course/";
	}
	
	@RequestMapping(value = "/getCourse", method = RequestMethod.GET)
	public ModelAndView getCourses(@RequestParam("id") Long id, @RequestParam("mode") String mode, ModelAndView model) {
		model.setViewName("courseDetail");
		model.addObject("course", courseService.get(id));
		model.addObject("mode",mode);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws Exception {
		courseService.delete(id);
	}
}
