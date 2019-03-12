package com.website.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entity.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("employeeHome", "employee", new Employee());
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("employee")Employee employee) {
		ModelAndView model = new ModelAndView();
		model.setViewName("employeeView");
		model.addObject("name", employee.getName());
        model.addObject("contactNumber", employee.getContactNumber());
        model.addObject("id", employee.getId());
		return model;
	}
}
