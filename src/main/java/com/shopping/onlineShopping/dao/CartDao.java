package com.shopping.onlineShopping.dao;

import com.shopping.onlineShopping.entity.Cart;
import com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages_zh_CN;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {

    @Autowired
    private SessionFactory sessionFactory;
    public Cart getCartById(int cartId) {
        Cart cart = null;
        try (Session session = sessionFactory.openSession() ) {
            cart = session.get(Cart.class, cartId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }

}
