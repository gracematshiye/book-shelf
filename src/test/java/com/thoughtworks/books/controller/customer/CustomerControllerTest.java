package com.thoughtworks.books.controller.customer;

import com.thoughtworks.books.controller.CustomerController;
import com.thoughtworks.books.entity.Customer;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.CustomerService;
import com.thoughtworks.books.service.ShoppingCartService;
import com.thoughtworks.books.service.impl.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService = new BookServiceImpl();

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    private CustomerService customerService;


    @InjectMocks
    private CustomerController controller;


    @Before
    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver).build();

    }

    @Test
    public void testHTTPStatusCreated() throws Exception {

        mockMvc.perform(post("/shop-cart/customer/add"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/books"));

    }

    @Test
    public void testAddCustomerMethodIsCalled() throws Exception {

        Customer customer = new Customer("Hlulani", "Chauke", "0799999999", "h@mail.com", "200 khumalo street, ivory park");
        doNothing().when(customerService).addCustomer(customer);
        customerService.addCustomer(customer);

        verify(customerService, atLeastOnce()).addCustomer(customer);
    }
}
