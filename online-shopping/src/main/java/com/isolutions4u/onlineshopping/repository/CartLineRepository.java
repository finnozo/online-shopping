package com.isolutions4u.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isolutions4u.onlineshopping.model.CartLine;

@Repository("cartLineRepository")
public interface CartLineRepository extends JpaRepository<CartLine, Integer>{

}
