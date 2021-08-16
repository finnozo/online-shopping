package com.isolutions4u.onlineshopping.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "/redirect:/manage/products";

    }

}
