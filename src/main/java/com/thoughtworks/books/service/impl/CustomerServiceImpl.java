package com.thoughtworks.books.service.impl;

import java.util.List;
import com.thoughtworks.books.dao.CustomerDao;
import com.thoughtworks.books.entity.Customer;
import com.thoughtworks.books.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public CustomerServiceImpl() {
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }
}
