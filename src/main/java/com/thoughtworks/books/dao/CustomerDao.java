package com.thoughtworks.books.dao;

import com.thoughtworks.books.entity.Customer;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);
    List<Customer> getCustomers();
}
