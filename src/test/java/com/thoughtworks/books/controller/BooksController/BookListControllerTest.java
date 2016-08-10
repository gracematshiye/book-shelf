package com.thoughtworks.books.controller.BooksController;

import com.thoughtworks.books.controller.BookController;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.CustomerService;
import com.thoughtworks.books.service.ShoppingCartService;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BookListControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService = new BookServiceImpl();

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    private CustomerService customerService;

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

        when(bookService.getBooks()).thenReturn(bookList);
    }

    /**
     * Verify that name of the rendered view is ‘bookShop’
     * ==============================================================
     */
    @Test
    public void testDisplayMethodIsCalled() throws Exception {  // from displayAll method
        String viewName = controller.displayAll(new ModelMap());
        Assert.assertEquals("bookShop", viewName);
    }

    /**
     * Verify that the  method was called
     * ==============================================================
     **/
    @Test
    public void testGetBooksMethodFromServiceIsCalled() throws Exception {  //from BookService
        Assert.assertEquals(bookList, bookService.getBooks());
        verify(bookService, times(1)).getBooks();
    }

    /**
     * Verify that the HTTP status code is 200.
     * ===============================================================
     **/
    @Test
    public void testVerifyTheHTTPStatusIsOkay() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }

    /**
     * Verify that the size of the book list is 1
     * =====================================================================
     **/
    @Test
    public void testBookListHasOneElement() throws Exception {  //from BookService

        try {
            mockMvc.perform(get("/books"))
                    .andExpect(model().attribute("books", hasSize(1)));

        } catch (Exception e) {
            e.printStackTrace();
            fail("Wrong URL");
        }
    }

    /**
     * Verify that the book list contains the correct items
     * ====================================================
     **/
    @Test
    public void testAttributeExists() throws Exception {  //from BookService
        mockMvc.perform(get("/books"))
                .andExpect(model().attribute("books", hasItem(
                        allOf(
                                hasProperty("name", is("Java")),
                                hasProperty("isbn", is("1-5555-t166-0")),
                                hasProperty("description", is("Java Book")),
                                hasProperty("price", is(new BigDecimal(150)))
                        ))));
    }

    @Test
    public void testBookListAttributeExists() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(model().attribute("books", this.bookService.getBooks()));
    }

    @Test
    public void testCartSizeAttributeExists() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(model().attribute("cartSize", this.shoppingCartService.getShopCartSize()));
    }

    /**
     * Verify that the request is forwarded to url ‘/WEB-INF/views/bookShop.jsp
     * =========================================================================
     **/
    @Test
    public void testRequestIsForwardedToUrl() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(forwardedUrl("/WEB-INF/views/bookShop.jsp"));
    }
}
