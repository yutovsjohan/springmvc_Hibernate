package com.website.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Address;
import com.website.springmvc.entities.Course;
import com.website.springmvc.entities.Student;
import com.website.springmvc.service.AddressService;
import com.website.springmvc.service.CourseService;
import com.website.springmvc.service.StudentService;

@Controller
@RequestMapping(value="/controller")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CourseService courseService;
	
	//xem danh sach
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ModelAndView getAll(){
		ModelAndView model = new ModelAndView();
		
		model.setViewName("studentList");
		model.addObject("students", studentService.getAll());
		model.addObject("addresses", addressService.getAll());
		
		return model;
	}
	
	//add + edit
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student, @RequestParam String btnSave){
		if(btnSave != "") {
			List<Course> list = new ArrayList<>();
			String[] ids = btnSave.split(",");
			for (int i = 0; i < ids.length; i++) {
				list.add(courseService.get((Long.parseLong(ids[i]))));
			}
			student.setCourses(list);
		}
		System.out.println("id" + student.getId());
		if (student.getId() == null) {
			studentService.add(student);
			System.out.println("added");
		} else {			
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
//		model.addObject("address",new Address());
		model.addObject("courses", courseService.getAll());
		model.addObject("mode", "ADD");
		
		return model;
	}
	
	//view, edit 
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView getStudentById(@RequestParam(name = "id") Long id, @RequestParam(name = "mode") String mode) {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("studentDetail");
		model.addObject("student", studentService.get(id));
//		model.addObject("address", addressService.get(id));	
		model.addObject("courses", courseService.getAll());
		model.addObject("mode",mode);

		return model;
	}	
	
 	//delete 
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public void btnDelete(@PathVariable(value = "id") Long id) {
		Student student = studentService.get(id);
		studentService.delete(student);
		addressService.delete(addressService.get(id));
	}
}
