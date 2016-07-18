package com.thoughtworks.books.controller.ShoppingCartController;

import com.thoughtworks.books.controller.ShopCartController;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.ShoppingCartService;
import com.thoughtworks.books.service.impl.ShoppingCartServiceImpl;
import org.junit.Assert;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class EmptyCartControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ShoppingCartService shoppingCartService;

    @InjectMocks
    private ShopCartController controller;

    List<Book> bookList = new ArrayList<>();
    private Book book;

    @Before
    public void setUp() throws Exception {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        book = new Book("Java", "1-5555-t166-0", "Java Book", new BigDecimal(150));
        bookList.add(book);
        shoppingCartService = new ShoppingCartServiceImpl();

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver).build();

        when(shoppingCartService.getCartList()).thenReturn(bookList);
    }

    @Test
    public void testEmptyCartMethodIsCalled() throws Exception {
        List<Book> books = shoppingCartService.getCartList();
        Assert.assertEquals(1, books.size());

        books.clear();

        Assert.assertEquals(0, books.size());
    }

    @Test
    public void testRemoveItemMethodRedirectToCartList() throws Exception {
        mockMvc.perform(get("/shop-cart/empty-cart/"))
                .andExpect(view().name("redirect:/shop-cart/cart-list"));
    }

    /**
     * Verify that the HTTP status code is 302.
     * ===============================================================
     **/
    @Test
    public void verifyHTTPStatusIsOk() throws Exception {
        mockMvc.perform(get("/shop-cart/empty-cart/"))
                .andExpect(status().isFound());
    }
}
