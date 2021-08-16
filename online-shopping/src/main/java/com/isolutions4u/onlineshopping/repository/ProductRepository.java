package com.isolutions4u.onlineshopping.repository;

import com.isolutions4u.onlineshopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductByCategoryId(Integer categoryId);

}
