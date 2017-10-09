package com.isolutions4u.onlineshopping.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@ControllerAdvice
public class GlobalDefaultExceptionHandler implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView("404");
		modelAndView.addObject("errorTitle", "This page is not constructed!");
		modelAndView.addObject("errorDescription", "The Page you are looking for is not available now!");
		modelAndView.addObject("title", "404 Error Page");
		return modelAndView;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}

	@ExceptionHandler(ProductNotFoundExceptoion.class)
	public ModelAndView errorProductNotfound() {
		ModelAndView modelAndView = new ModelAndView("404");
		modelAndView.addObject("errorTitle", "This Product Not Available");
		modelAndView.addObject("errorDescription", "The Product you looking for is not available right Now!");
		modelAndView.addObject("title", "Product Unavailable");
		return modelAndView;
	}

}
