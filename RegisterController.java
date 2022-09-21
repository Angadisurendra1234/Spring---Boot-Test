package com.user.registry.app.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.registry.app.model.User;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/showUserForm")
	public String viewRegistration(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "Registration";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/displayUser")
	public String processRegistration(@ModelAttribute("user") User user) {

		return "RegistrationSuccess";
	}
}