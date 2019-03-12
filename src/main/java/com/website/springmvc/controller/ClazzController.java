package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entity.Clazz;
import com.website.springmvc.service.ClazzService;


@Controller
@RequestMapping(value = "/views/clazz")
public class ClazzController {
	@Autowired
	private ClazzService clazzService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept = application/json")
	public ModelAndView getClazzs(ModelAndView model) {
		model.setViewName("clazz");
		model.addObject("clazz", clazzService.getAll());
		return model;
	}
	
	@RequestMapping(value = "/addClazz", method = RequestMethod.GET)
	public ModelAndView addClazzs(ModelAndView model) {
		model.setViewName("clazzDetail");
		model.addObject("clazz", new Clazz());
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("clazz") Clazz clazz) throws Exception {
		if(clazz.getId() == null) {
			clazzService.add(clazz);
		}
		else {
			clazzService.update(clazz);
		}
		return "redirect:/views/clazz/";
	}
	
	@RequestMapping(value = "/getClazz", method = RequestMethod.GET)
	public ModelAndView getClazzs(@RequestParam("id") Long id, @RequestParam("mode") String mode, ModelAndView model) {
		model.setViewName("clazzDetail");
		model.addObject("clazz", clazzService.get(id));
		model.addObject("mode",mode);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws Exception {
		clazzService.delete(id);
	}
}
