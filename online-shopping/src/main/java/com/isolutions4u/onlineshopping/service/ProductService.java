package com.isolutions4u.onlineshopping.service;

import java.util.List;

import com.isolutions4u.onlineshopping.model.Product;

public interface ProductService {

	String saveProduct(Product product);

	List<Product> findAllProducts();
	
	List<Product> findAllProductsForAdmin();

	Product findProductById(Integer id);

	String deleteProduct(Integer id);

	String updateProduct(Product product);

	List<Product> findProductByCategoryId(Integer categoryId);

	Product findProductByIdForAdmin(int id);
	

}
