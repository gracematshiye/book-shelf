package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Customer;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/shop-cart/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer) {

        if (customer.getId() == 0){
            customerService.addCustomer(customer);
        }

        return "redirect:/books";
    }
}
