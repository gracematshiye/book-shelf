package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.ShoppingCart;
import com.thoughtworks.books.service.impl.BookServiceImpl;
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
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/webapp/resources/spring-applicationContext-controller.xml")
public class ShopCartControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService = new BookServiceImpl();

    @Mock
    private ShoppingCart shoppingCart;

    @InjectMocks
    private BookController controller;

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

        when(shoppingCart.getCartList()).thenReturn(bookList);

    }
    /**
     * Verify that name of the rendered view is ‘bookShop’
     * ==============================================================
     */
    @Test
    public void testAddToCartMethodIsCalled() throws Exception {  //from addToCart method
        int id = 1;
        mockMvc.perform(get("/shop-cart/" + id))
                .andExpect(view().name("main"));
    }

    /**
     * Verify that the  method was called
     * ==============================================================
     **/
    @Test
    public void testGetCartListMethodIsCalled() throws Exception {  //from Shopping Cart
        Assert.assertEquals(bookList, shoppingCart.getCartList());
        verify(shoppingCart, times(1)).getCartList();
    }

    /**
     * Verify that the HTTP status code is 200.
     * ===============================================================
     **/
    @Test
    public void verifyHTTPStatusIsOk() throws Exception {

        int id = 1;
        mockMvc.perform(get("/shop-cart/" + id))
                .andExpect(status().isOk());

    }

    /**
     * Verify that shopping cart return the number of items in a cart list
     * ===================================================================
     **/
    @Test
    public void testCartAttributeExists() throws Exception {
        int id = 1;
        shoppingCart.addToCart(first);
        mockMvc.perform(get("/shop-cart/" + id))
                .andExpect(model().attributeExists("cartSize"))
                .andExpect(model().attribute("cartSize", shoppingCart.getShopCartCount()));

    }

    /**
     * Verify that the request is forwarded to url ‘/WEB-INF/views/bookShop.jsp
     * =========================================================================
     **/
    @Test
    public void testRequestIsForwardedToUrl() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(forwardedUrl("/WEB-INF/views/main.jsp"));

    }
}


