package com.thoughtworks.books.service.customer;

import com.thoughtworks.books.dao.CustomerDao;
import com.thoughtworks.books.entity.Customer;
import com.thoughtworks.books.service.CustomerService;
import com.thoughtworks.books.service.impl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    @Mock
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    /**
     * Add a Customer and verify if the addCustomer() method was called
     */

    @Test
    public void testAddCustomerMethodIsCalled() throws Exception {

        doNothing().when(customerDao).addCustomer(any(Customer.class));
        customerService.addCustomer(any(Customer.class));
        verify(customerDao, atLeastOnce()).addCustomer(any(Customer.class));
    }

    /**
     * Check that getCustomers() method return customerList when it is called
     */
    @Test
    public void testGetAllBooks() throws Exception {

        when(customerDao.getCustomers()).thenReturn(customerList);

        Assert.assertEquals(customerService.getCustomers(), customerList);
        customerService.getCustomers();
        verify(customerDao, atLeastOnce()).getCustomers();
    }
}
