package com.shopping.onlineShopping.service;

import com.shopping.onlineShopping.dao.CartDao;
import com.shopping.onlineShopping.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartDao cartDao;
    public Cart getCartById (int cartId) {
        return cartDao.getCartById(cartId);
    }
}
