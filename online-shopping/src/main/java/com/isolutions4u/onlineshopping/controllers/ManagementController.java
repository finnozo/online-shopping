package com.isolutions4u.onlineshopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.isolutions4u.onlineshopping.model.Category;
import com.isolutions4u.onlineshopping.model.Product;
import com.isolutions4u.onlineshopping.service.CategoryService;
import com.isolutions4u.onlineshopping.service.ProductService;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Qualifier("categoryService")
	@Autowired
	private CategoryService categoryService;

	@Qualifier("productService")
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public ModelAndView showMangeProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView modelAndView = new ModelAndView("page");

		modelAndView.addObject("userClickManageProducts", true);
		modelAndView.addObject("title", "Manage Products");

		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		modelAndView.addObject("product", nProduct);
		if (operation != null && operation.equals("product")) {
			modelAndView.addObject("message", "Product Added Sucessfully!");
		}

		return modelAndView;
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		List<Category> categories = categoryService.findAllCategories();
		return categories;
	}

	// handling product submission
	@PostMapping(value = "/products")
	public String handleProductSubmission(@ModelAttribute("product") Product mProduct) {

		// create new Product record

		productService.saveProduct(mProduct);

		return "redirect:/manage/products?operation=product";
	}

}
