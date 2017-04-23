package com.app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam String error ,
			@RequestParam String logout  ) {
		log.info("login() - start");
		ModelAndView modelAndView = new ModelAndView();
		
		if(null != error){
			modelAndView.addObject("loginError", "Invalid Username or Password");
		}
		if(null != logout){
			modelAndView.addObject("logoutSuccess", "You have loggedout successfully");
		}
		
		
		modelAndView.setViewName("login");
		log.info("login() - end");
		return modelAndView;

	}

}
