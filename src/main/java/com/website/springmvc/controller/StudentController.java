package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entity.Student;
import com.website.springmvc.service.StudentService;

@Controller
@RequestMapping(value = "/views/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept = application/json")
	public ModelAndView getStudents(ModelAndView model) {
		model.setViewName("student");
		model.addObject("student", studentService.getAll());
		return model;
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView addStudents(ModelAndView model) {
		model.setViewName("studentDetail");
		model.addObject("student", new Student());
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("student") Student student) throws Exception {
		if(student.getId() == null) {
			studentService.add(student);
		}
		else {
			studentService.update(student);
		}
		return "redirect:/views/student/";
	}
	
	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public ModelAndView getStudents(@RequestParam("id") Long id, @RequestParam("mode") String mode, ModelAndView model) {
		model.setViewName("studentDetail");
		model.addObject("student", studentService.get(id));
		model.addObject("mode",mode);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws Exception {
		studentService.delete(id);
	}
}
