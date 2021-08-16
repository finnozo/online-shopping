package com.isolutions4u.onlineshopping.controllers;

import com.isolutions4u.onlineshopping.model.Product;
import com.isolutions4u.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping("/all/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return products;

    }

    @GetMapping("/admin/all/products")
    public List<Product> getAllProductsForAdmin() {
        List<Product> products = productService.findAllProductsForAdmin();
        return products;

    }

    @GetMapping("/category/{categoryId}/products")
    public List<Product> getProductsByCategory(@PathVariable("categoryId") int categoryId) {
        List<Product> products = productService.findProductByCategoryId(categoryId);
        return products;

    }

}
