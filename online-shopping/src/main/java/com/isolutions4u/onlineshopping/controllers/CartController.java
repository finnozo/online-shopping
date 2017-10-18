package com.isolutions4u.onlineshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isolutions4u.onlineshopping.service.CartLineService;

@Controller
@RequestMapping("/cart")
public class CartController {

	
	@Autowired
	@Qualifier("cartLineService")
	private CartLineService cartLineService;

	@GetMapping("/show")
	public ModelAndView showCart() {
		ModelAndView modelAndView = new ModelAndView("page");

		modelAndView.addObject("title", "User Cart");
		modelAndView.addObject("userClickShowCart", true);
		modelAndView.addObject("cartLines", cartLineService.findCartLines());
		System.out.println(cartLineService.findCartLines());
		return modelAndView;
	}

}
