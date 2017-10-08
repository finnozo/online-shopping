package com.isolutions4u.onlineshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.isolutions4u.onlineshopping.dao.CategoryDAO;
import com.isolutions4u.onlineshopping.model.Category;

@Controller
public class IndexController {

	@Autowired
	private CategoryDAO categoryDAO;

	@GetMapping(value = { "/", "/home" })
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("userClickHome", true);
		modelAndView.addObject("title", "Home");

		// passing the list of categories

		modelAndView.addObject("categories", categoryDAO.list());

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
	
	/*
	 * Methods to load all the products and based on category
	 * 
	 * */
	
	@GetMapping("/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("userClickAllProducts", true);
		modelAndView.addObject("title", "All Products");

		// passing the list of categories

		modelAndView.addObject("categories", categoryDAO.list());

		return modelAndView;
	}
	
	
	@GetMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		
		Category category = null;
		category = categoryDAO.get(id);
		
		modelAndView.addObject("userClickCategoryProducts", true);
		modelAndView.addObject("title", category.getName());

		// passing the list of categories

		modelAndView.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		modelAndView.addObject("category",category);

		return modelAndView;
	}

	
}
