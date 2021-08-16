package com.isolutions4u.onlineshopping.repository;

import com.isolutions4u.onlineshopping.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cartRepository")
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
