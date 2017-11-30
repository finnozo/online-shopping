package com.isolutions4u.onlineshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.isolutions4u.onlineshopping.model.Cart;
import com.isolutions4u.onlineshopping.model.CartLine;
import com.isolutions4u.onlineshopping.model.Product;
import com.isolutions4u.onlineshopping.service.CartLineService;
import com.isolutions4u.onlineshopping.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	@Qualifier("cartLineService")
	private CartLineService cartLineService;

	@Autowired
	@Qualifier("cartService")
	private CartService cartService;

	@GetMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {
		ModelAndView modelAndView = new ModelAndView("page");

		if (result != null) {
			switch (result) {
			case "updated":
				modelAndView.addObject("message", "CartLine has been updated sucessfully");
				break;

			case "error":
				modelAndView.addObject("message", "Something went wrong!!");
				break;

			case "deleted":
				modelAndView.addObject("message", "Cart has been removed sucessfully");
				break;
			default:
				break;
			}
		}

		modelAndView.addObject("title", "User Cart");
		modelAndView.addObject("userClickShowCart", true);
		modelAndView.addObject("cartLines", cartLineService.findCartLines());
		return modelAndView;
	}

	@GetMapping("/{id}/update")
	public String updateCart(@PathVariable int id, @RequestParam int count) {
		CartLine cartLine = cartLineService.findCartLineById(id);
		if (cartLine != null) {
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			if (product.getQuantity() <= count) {
				count = product.getQuantity();
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			String response = cartLineService.updateCartLine(cartLine) + "";
			Cart cart = cartService.findCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartService.updateCart(cart);
			return "redirect:/cart/show?result=updated";
		} else {
			return "redirect:/cart/show?result=error";
		}
	}

	@GetMapping("/{id}/delete")
	public String deletCart(@PathVariable int id) {
		// TODO : fetch the cartLine
		CartLine cartLine = cartLineService.findCartLineById(id);
		if (cartLine != null) {
			Cart cart = cartService.findCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartService.updateCart(cart);
			// TODO : remove the cartLine
			cartLineService.deleteCartLine(cartLine);
			return "redirect:/cart/show?result=deleted";
		} else {
			return "redirect:/cart/show?result=error";
		}
	}

}
