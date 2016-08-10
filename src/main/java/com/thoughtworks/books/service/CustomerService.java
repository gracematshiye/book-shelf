package com.thoughtworks.books.service;

import com.thoughtworks.books.entity.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

   List<Customer> getCustomers();
}
