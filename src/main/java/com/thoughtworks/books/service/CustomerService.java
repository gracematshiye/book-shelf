package com.thoughtworks.books.service;

import com.thoughtworks.books.entity.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);

    java.util.List<Customer> getCustomers();
}
