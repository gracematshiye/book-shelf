package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/webapp/resources/test-mvc-dispatcher-servlet.xml")
public class BookControllerTest {

    private MockMvc mockMvc;


    @Mock
    private BookService bookService = new BookServiceImpl();

    @InjectMocks
    private BookController controller;

    List<Book> bookList = new ArrayList<>();
    Book first = new Book("Java", "1-5555-t166-0", "Java Book", new BigDecimal(150));

    @Before
    public void setUp() throws Exception {

        bookList.add(first);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(bookService.getBooks()).thenReturn(bookList);

    }

    @Test
    public void testDisplayMethodIsCalled() throws Exception {

        String viewName = controller.displayAll(new ModelMap());
        Assert.assertEquals("bookShop", viewName);

    }

    @Test
    public void testGetBooksMethodFromServiceIsCalled() throws Exception {

        Assert.assertEquals(bookList,bookService.getBooks());
        verify(bookService, times(1)).getBooks();


    }

    @Test
    public void testVerifyTheHTTPStatusIsOkay() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

    }

    @Test
    public void testBookListHasOneElement() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(model().attribute("books", hasSize(1)));

    }

    @Test
    public void testAttributeExists() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(model().attribute("books", hasItem(
                        allOf(
                                hasProperty("name", is("Java")),
                                hasProperty("isbn", is("1-5555-t166-0")),
                                hasProperty("description", is("Java Book")),
                                hasProperty("price", is(new BigDecimal(150)))
                        ))));

    }
}
