package com.shopping.onlineShopping.dao;

import com.shopping.onlineShopping.entity.Cart;
import com.shopping.onlineShopping.entity.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            // add if not exist or just update
            session.saveOrUpdate(cartItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // cartItem was referenced by cart
    // so have to remove it from cart first
    // and then remove the cartItem itself
    public void removeCartItem(int cartItemId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CartItem cartItem = session.get(CartItem.class, cartItemId);
            Cart cart = cartItem.getCart();
            List<CartItem> cartItems = cart.getCartItem();
            cartItems.remove(cartItem);
            session.beginTransaction();
            session.delete(cartItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItem();
        for (CartItem cartItem : cartItems) {
            removeCartItem(cartItem.getId());
        }
    }




}
