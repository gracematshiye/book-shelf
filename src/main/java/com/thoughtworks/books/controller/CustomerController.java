package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Customer;
import com.thoughtworks.books.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/shop-cart/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.addCustomer(customer);

        return "redirect:/books";
    }
}
