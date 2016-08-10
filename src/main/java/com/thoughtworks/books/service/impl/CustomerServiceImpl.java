package com.thoughtworks.books.service.impl;

import java.util.List;
import com.thoughtworks.books.dao.CustomerDao;
import com.thoughtworks.books.entity.Customer;
import com.thoughtworks.books.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public CustomerServiceImpl() {
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }
}
