package com.thoughtworks.books.dao;

import com.thoughtworks.books.entity.Customer;

import java.util.List;

public interface CustomerDao {
    public void addCustomer(Customer customer);
    public List<Customer> getCustomers();
}
