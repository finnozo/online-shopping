package com.isolutions4u.onlineshopping.controllers;

import com.isolutions4u.onlineshopping.model.Cart;
import com.isolutions4u.onlineshopping.model.CartLine;
import com.isolutions4u.onlineshopping.model.Product;
import com.isolutions4u.onlineshopping.service.CartLineService;
import com.isolutions4u.onlineshopping.service.CartService;
import com.isolutions4u.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    @Qualifier("cartLineService")
    private CartLineService cartLineService;

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

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

                case "added":
                    modelAndView.addObject("message", "Cartline has been added sucessfully!");
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
    public String deleteCart(@PathVariable int id) {
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

    @GetMapping("/add/{id}/product")
    public String addCart(@PathVariable int id) {
        // TODO : fetch the cart
        Cart cart = cartService.findCart();
        CartLine cartLine = cartLineService.findCartLineByCartIdAndProductId(cart.getId(), id);
        if (cartLine != null) {

			/*cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartService.updateCart(cart);
			// TODO : remove the cartLine
			cartLineService.deleteCartLine(cartLine);
			return "redirect:/cart/show?result=deleted";*/
            return "";
        } else {
            cartLine = new CartLine();

            Product product = productService.findProductById(id);
            cartLine.setCartId(cart.getId());
            cartLine.setProduct(product);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setProductCount(1);
            cartLine.setTotal(product.getUnitPrice());
            cartLine.setAvailable(true);
            cartLineService.saveCartLine(cartLine);
            cart.setCartLines(cart.getCartLines() + 1);
            cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
            cartService.saveCart(cart);
            return "redirect:/cart/show?result=added";
        }
    }

}
