package com.isolutions4u.onlineshopping.service;

import com.isolutions4u.onlineshopping.model.CartLine;

import java.util.List;

public interface CartLineService {

    public CartLine findCartLineById(int id);

    public boolean saveCartLine(CartLine cartLine);

    public boolean updateCartLine(CartLine cartLine);

    public boolean deleteCartLine(CartLine cartLine);

    public List<CartLine> findAllCartLine(int cartId);

    public List<CartLine> findCartLines();

    CartLine findCartLineByCartIdAndProductId(int cartId, int id);

}
