package com.code.codeevents.controllers;

import com.code.codeevents.service.UserServiceImpl;
import com.code.codeevents.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome, " + user.getEmail() + "!" );
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		if(user.getRoles().get(0).getName().equals("USER"))
				modelAndView.setViewName("/index");
			else
				modelAndView.setViewName("admin/index");
		return modelAndView;
	}
}
