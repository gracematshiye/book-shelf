package com.thoughtworks.books.controller.ShoppingCartController;

import com.thoughtworks.books.controller.ShopCartController;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.ShoppingCartService;
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

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmptyShoppingCartControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ShoppingCartService shoppingCart;

    @InjectMocks
    private ShopCartController controller;

    List<Book> bookList = new ArrayList<>();
    Book first = new Book(1, "Java", "1-5555-t166-0", "Java Book", new BigDecimal(150));
    Book second = new Book(2, "C#", "9-5555-t186-0", "Basics of C#", new BigDecimal(190));

    @Before
    public void setUp() throws Exception {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        bookList.add(first);
        bookList.add(second);

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver).build();


    }

    @Test
    public void emptyCartListThenRedirectToCartList() throws Exception {
        mockMvc.perform(delete("/shop-cart/empty-cart"))
                .andExpect(redirectedUrl("/shop-cart/cart-list"));
    }

    @Test
    public void verifyHTTPStatusIsFound() throws Exception {

        mockMvc.perform(delete("/shop-cart/empty-cart"))
                .andExpect(status().isFound());

    }

    @Test
    public void testRemoveItemFromCart() throws Exception {


        when(shoppingCart.getCartList()).thenReturn(bookList);

        mockMvc.perform(delete("/shop-cart/empty-cart"))
                .andExpect(model().attribute("cartList", hasSize(2)));

        bookList.clear();
        when(shoppingCart.getCartList()).thenReturn(bookList);

        verify(shoppingCart, times(1)).clearCart();

        mockMvc.perform(delete("/shop-cart/empty-cart"))
                .andExpect(model().attribute("cartList", hasSize(0)));
    }
}
