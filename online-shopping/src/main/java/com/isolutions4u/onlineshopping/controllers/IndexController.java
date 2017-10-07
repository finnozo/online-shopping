package com.isolutions4u.onlineshopping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping(value = { "/", "/home" })
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("userClickHome", true);
		modelAndView.addObject("title", "Home");

		return modelAndView;
	}

	@GetMapping("/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("userClickContact", true);
		modelAndView.addObject("title", "Contact Us");

		return modelAndView;
	}

	@GetMapping("/about")
	public ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("userClickAbout", true);
		modelAndView.addObject("title", "About Us");

		return modelAndView;
	}

}
