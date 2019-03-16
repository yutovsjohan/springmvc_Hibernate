package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Student;
import com.website.springmvc.service.StudentService;

@Controller
@RequestMapping(value="/controller")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//xem danh sach
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ModelAndView getAll(){
		ModelAndView model = new ModelAndView();
		
		model.setViewName("studentList");
		model.addObject("students", studentService.getAll());
		
		return model;
	}
	
	//them 
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student){
		if(student.getId() == null){
			studentService.add(student);
		}
		else{
			studentService.update(student);
		}
		return "redirect:/controller/students";
	}
	
	//toi trang them 
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView addStudent(){
		ModelAndView model = new ModelAndView();
		
		model.setViewName("studentDetail");
		model.addObject("student",new Student());
		model.addObject("mode", "EDIT");
		
		return model;
	}
	
	//view, edit 
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView getStudentById(@RequestParam(name = "id") Long id, @RequestParam(name = "mode") String mode) {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("studentDetail");
		model.addObject("student", studentService.get(id));
		model.addObject("mode",mode);

		return model;
	}	
	
 	//delete 
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET) 
	public String studentCourse(@PathVariable("id") Long id){
		studentService.delete(id);
		return "redirect:/controller/students";
	}
}
