package com.isolutions4u.onlineshopping.service;

import com.isolutions4u.onlineshopping.model.Cart;
import com.isolutions4u.onlineshopping.model.UserModel;
import com.isolutions4u.onlineshopping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Qualifier("cartRepository")
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private HttpSession httpSession;

    @Override
    public boolean saveCart(Cart cart) {
        // TODO Auto-generated method stub
        cartRepository.saveAndFlush(cart);
        return true;
    }

    @Override
    public boolean updateCart(Cart cart) {
        // TODO Auto-generated method stub
        cartRepository.saveAndFlush(cart);
        return true;
    }

    @Override
    public Cart findCart() {
        // TODO Auto-generated method stub
        return ((UserModel) httpSession.getAttribute("userModel")).getCart();
    }

}
