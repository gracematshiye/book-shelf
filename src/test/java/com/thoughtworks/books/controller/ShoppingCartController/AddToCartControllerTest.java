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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration("file:src/test/webapp/resources/spring-applicationContext-controller.xml")
public class AddToCartControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @Mock
    private ShoppingCartService shoppingCartService;

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
        bookService = new BookServiceImpl();
        shoppingCartService = new ShoppingCartServiceImpl();

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver).build();

        when(shoppingCartService.getCartList()).thenReturn(bookList);
    }

    @Test
    public void testAddSpecificBookToCart() throws Exception {
        int id = 1;
        List<Book> books = this.bookService.getBooks();

        Assert.assertEquals(1, shoppingCartService.getCartList().size());

        for (int i = 0; i < books.size(); i++) {

            Assert.assertTrue(id == books.get(i).getId());

            if (id == books.get(i).getId()){

                doNothing().when(shoppingCartService).addToCart(books.get(i));

                shoppingCartService.addToCart(books.get(i));

                verify(shoppingCartService, times(1)).addToCart(books.get(i));

            }

            Assert.assertEquals(2, shoppingCartService.getCartList().size());
        }
    }

    /**
     * Verify that shopping cart return the number of items in a cart list
     * ===================================================================
     **/
    @Test
    public void testCartAttributeExists() throws Exception {
        int id = 1;
        shoppingCartService.addToCart(first);
        mockMvc.perform(get("/shop-cart/" + id))
                .andExpect(model().attribute("cartSize", shoppingCartService.getShopCartCount()));
    }

    /**
     * Verify that name of the rendered view is ‘bookShop’
     * ==============================================================
     */
    @Test
    public void testAddToCartRedirectToBooks() throws Exception {  //from addToCart method
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
}


