package com.isolutions4u.onlineshopping.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
			BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file,
			HttpServletRequest request) {

		// check if there are any error

		if (bindingResult.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}

		if (file.isEmpty()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Please select a file to upload");
			return "page";
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			String p = request.getSession().getServletContext().getRealPath("/static/images/");
			System.out.println(p);
			Path path = Paths.get(p + mProduct.getCode() + ".jpg");
			Files.write(path, bytes);
			productService.saveProduct(mProduct);
			return "redirect:/manage/products?operation=product";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", e.getMessage());
			return "page";
		}

	}

}
