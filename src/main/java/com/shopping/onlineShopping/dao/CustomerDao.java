package com.shopping.onlineShopping.dao;

import com.shopping.onlineShopping.entity.Authorities;
import com.shopping.onlineShopping.entity.Customer;
import com.shopping.onlineShopping.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(customer.getUser().getEmailId());
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            // if there is error, rollback the transaction
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                // release the session back to the session pool
                session.close();
            }
        }

    }

    public Customer getCustomerByUserName(String email) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(user != null) {
            return user.getCustomer();
        }

        return null;
    }

}


