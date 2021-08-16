package com.isolutions4u.onlineshopping.service;

import com.isolutions4u.onlineshopping.model.Cart;

public interface CartService {

    boolean saveCart(Cart cart);

    boolean updateCart(Cart cart);

    Cart findCart();

}
