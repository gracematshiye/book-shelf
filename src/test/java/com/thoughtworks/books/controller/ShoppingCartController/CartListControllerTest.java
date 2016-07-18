package com.thoughtworks.books.controller.ShoppingCartController;

import com.thoughtworks.books.controller.ShopCartController;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.ShoppingCartService;
import com.thoughtworks.books.service.impl.BookServiceImpl;
import com.thoughtworks.books.service.impl.ShoppingCartServiceImpl;
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

@ContextConfiguration("file:src/test/webapp/resources/spring-applicationContext-controller.xml")
public class CartListControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    private BookService bookService;

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
        shoppingCartService = new ShoppingCartServiceImpl();
        bookService = new BookServiceImpl();

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver).build();

        when(shoppingCartService.getCartList()).thenReturn(bookList);
    }

    /**
     * Check if RequestMethod URL "/shop-cart/cart-list" returns cart-list
     */
    @Test
    public void testCartListMethodIsCalled() throws Exception {
        mockMvc.perform(get("/shop-cart/cart-list"))
                .andExpect(view().name("cart-list"));
    }

    /**
     * Check if getCartList() method was called
     */
    @Test
    public void testGetCartListMethodIsCalled() throws Exception {  //from Shopping Cart

        List<Book> books = this.shoppingCartService.getCartList();
        Assert.assertEquals(bookList, books);

        for (int i = 0; i < bookList.size(); i++) {
            when(shoppingCartService.getCartList()).thenReturn(bookList);
            when(shoppingCartService.cartTotal()).thenReturn(bookList.get(i).getPrice());
            when(shoppingCartService.getShopCartCount()).thenReturn(bookList.size());

        }
        verify(shoppingCartService, times(1)).getCartList();
    }

    /**
     * Check if RequestMethod URL "/shop-cart/cart-list" HTTp status isOk
     */
    @Test
    public void verifyHTTPStatusIsOk() throws Exception {
        mockMvc.perform(get("/shop-cart/cart-list"))
                .andExpect(status().isOk());
    }

    /**
     * Check if model attribute cartList returns list of books
     */
    @Test
    public void testCartListAttributeExists() throws Exception {
        mockMvc.perform(get("/shop-cart/cart-list"))
                .andExpect(model().attribute("cartList", this.shoppingCartService.getCartList()));
    }

    /**
     * Check if model attribute cartTotal returns cartList total
     */
    @Test
    public void testCartTotalAttributeExists() throws Exception {
        mockMvc.perform(get("/shop-cart/cart-list"))
                .andExpect(model().attribute("cartTotal", shoppingCartService.cartTotal()));
    }

    /**
     * Check if model attribute cartSize returns the size of the ca
     */
    @Test
    public void testCartSizeAttributeExists() throws Exception {
        mockMvc.perform(get("/shop-cart/cart-list"))
                .andExpect(model().attribute("cartSize", this.shoppingCartService.getShopCartCount()));
    }

    @Test
    public void testRequestIsForwardedToUrl() throws Exception {
        mockMvc.perform(get("/shop-cart/cart-list"))
                .andExpect(forwardedUrl("/WEB-INF/views/cart-list.jsp"));
    }
}
