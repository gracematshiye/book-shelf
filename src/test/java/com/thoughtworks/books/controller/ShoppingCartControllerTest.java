package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.entity.ShoppingCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/webapp/resources/spring-applicationContext-controller.xml")
public class ShoppingCartControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ShoppingCart shoppingCart;

    @InjectMocks
    private ShoppingCartController shoppingCartController;


    List<Book> bookList = new ArrayList<>();
    Book first = new Book("Java", "1-5555-t166-0", "Java Book", new BigDecimal(150));

    @Before
    public void setUp() throws Exception {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        bookList.add(first);

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(shoppingCartController)
                .setViewResolvers(viewResolver).build();
        when(shoppingCart.getCartList()).thenReturn(bookList);

    }

    @Test
    public void testAddToCartMethodIsCalled() throws Exception {
        int id = 1;
        mockMvc.perform(get("/shop-cart/"+id))
                .andExpect(view().name("bookShop"));
    }

    @Test
    public void testGetBooksMethodFromServiceIsCalled() throws Exception {

        Assert.assertEquals(bookList,shoppingCart.getCartList());
        verify(shoppingCart, times(1)).getCartList();

    }

    @Test
    public void verifyHTTPStatusIsOk() throws Exception {

        int id = 1;
        mockMvc.perform(get("/shop-cart/"+id))
                .andExpect(status().isOk());

    }

    @Test
    public void testAttributeExists() throws Exception {
        int id = 1;
        shoppingCart.addToCart(first);
        mockMvc.perform(get("/shop-cart/"+id))
                .andExpect(model().attributeExists("cartSize"))
                .andExpect(model().attribute("cartSize", shoppingCart.getShopCartCount()));

    }
}
