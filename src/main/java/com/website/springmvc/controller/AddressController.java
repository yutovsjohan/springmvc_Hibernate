package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entity.Address;
import com.website.springmvc.service.AddressService;

@Controller
@RequestMapping(value = "/views/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept = application/json")
	public ModelAndView getAddresss(ModelAndView model) {
		model.setViewName("address");
		model.addObject("address", addressService.getAll());
		return model;
	}
	
	@RequestMapping(value = "/addAddress", method = RequestMethod.GET)
	public ModelAndView addAddresss(ModelAndView model) {
		model.setViewName("addressDetail");
		model.addObject("address", new Address());
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("address") Address address) throws Exception {
		if(address.getId() == null) {
			addressService.add(address);
		}
		else {
			addressService.update(address);
		}
		return "redirect:/views/address/";
	}
	
	@RequestMapping(value = "/getAddress", method = RequestMethod.GET)
	public ModelAndView getAddresss(@RequestParam("id") Long id, @RequestParam("mode") String mode, ModelAndView model) {
		model.setViewName("addressDetail");
		model.addObject("address", addressService.get(id));
		model.addObject("mode",mode);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws Exception {
		addressService.delete(id);
	}
}

