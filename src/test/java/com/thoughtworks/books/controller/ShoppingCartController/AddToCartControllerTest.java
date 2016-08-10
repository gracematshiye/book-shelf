package com.thoughtworks.books.controller.ShoppingCartController;

import com.thoughtworks.books.controller.ShopCartController;
import com.thoughtworks.books.entity.Book;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AddToCartControllerTest {

    private MockMvc mockMvc;


    @Mock
    private BookService bookService = new BookServiceImpl();

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private ShopCartController controller;

    List<Book> bookList = new ArrayList<>();
    Book first = new Book("Java", "1-5555-t166-0", "Java Book", new BigDecimal(150));

    @Before
    public void setUp() throws Exception {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        bookList.add(first);

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver).build();

        when(shoppingCartService.getCartList()).thenReturn(bookList);

    }

    /**
     * Verify that name of the rendered view is ‘bookShop’
     * ==============================================================
     */
    @Test
    public void testAddToCartThatItCanRedirectToBooks() throws Exception {  //from addToCart method
        int id = 1;
        mockMvc.perform(get("/shop-cart/" + id))
                .andExpect(view().name("redirect:/books"));
    }

    /**
     * Verify that the HTTP status code is 302.
     * ===============================================================
     **/
    @Test
    public void verifyHTTPStatusIsFound() throws Exception {

        int id = 1;
        mockMvc.perform(get("/shop-cart/" + id))
                .andExpect(status().isFound());

    }

    @Test
    public void testAddToCartMethodIsCalled() throws Exception {
        shoppingCartService.addToCart(any(Book.class));
        verify(shoppingCartService, atLeastOnce()).addToCart(any(Book.class));

    }

    /**
     * Verify that shopping cart return the number of items in a cart list
     * ===================================================================
     **/
    @Test
    public void testCartAttributeExists() throws Exception {
        int id = 1;
        mockMvc.perform(get("/shop-cart/" + id))
                .andExpect(model().attribute("cartSize", shoppingCartService.getShopCartSize()));

    }
}


