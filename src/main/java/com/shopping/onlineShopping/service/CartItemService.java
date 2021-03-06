package com.shopping.onlineShopping.service;

import com.shopping.onlineShopping.dao.CartItemDao;
import com.shopping.onlineShopping.entity.Cart;
import com.shopping.onlineShopping.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(int cartItemId) {
        cartItemDao.removeCartItem(cartItemId);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

}
