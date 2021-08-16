package com.isolutions4u.onlineshopping.service;

import com.isolutions4u.onlineshopping.model.Cart;
import com.isolutions4u.onlineshopping.model.CartLine;
import com.isolutions4u.onlineshopping.repository.CartLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartLineService")
public class CartLineServiceImpl implements CartLineService {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartLineRepository cartLineRepository;

    @Override
    public CartLine findCartLineById(int id) {
        // TODO Auto-generated method stub
        return cartLineRepository.getOne(id);
    }

    @Override
    public boolean saveCartLine(CartLine cartLine) {
        // TODO Auto-generated method stub
        cartLineRepository.saveAndFlush(cartLine);
        return true;
    }

    @Override
    public boolean updateCartLine(CartLine cartLine) {
        // TODO Auto-generated method stub
        cartLineRepository.saveAndFlush(cartLine);
        return true;
    }

    @Override
    public boolean deleteCartLine(CartLine cartLine) {
        // TODO Auto-generated method stub
        cartLineRepository.delete(cartLine);
        return false;
    }

    @Override
    public List<CartLine> findAllCartLine(int cartId) {
        // TODO Auto-generated method stub
        return cartLineRepository.findAll();
    }

    @Override
    public List<CartLine> findCartLines() {
        Cart cart = cartService.findCart();
        return cartLineRepository.findCartLineByCartId(cart.getId());
    }

    @Override
    public CartLine findCartLineByCartIdAndProductId(int cartId, int id) {
        // TODO Auto-generated method stub
        return cartLineRepository.findCartLineByCartIdAndProductId(cartId, id);
    }

}
