package com.shopping.onlineShopping.service;

import com.shopping.onlineShopping.dao.CustomerDao;
import com.shopping.onlineShopping.entity.Cart;
import com.shopping.onlineShopping.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customer.getUser().setEnabled(true);
        Cart cart = new Cart();
        customer.setCart(cart);

        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String email) {
        return customerDao.getCustomerByUserName(email);
    }

}
