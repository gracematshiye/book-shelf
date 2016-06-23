package com.thoughtworks.books.controller;

import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:test-mvc-dispatcher-servlet.xml")
public class BookControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookController bookController;

    private List<Book> bookList = new ArrayList<>();
    private Book book1 = new Book("Java OOP", "1-5555-t166-0", "Java Book", new BigDecimal(150));


    @Before
    public void setUp() throws Exception {

        bookList.add(book1);

        bookService.addBook(book1);

        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void itShouldDisplayBookShop() throws Exception {

//        when(bookService.getBooks()).thenReturn(bookList);

        System.out.println(bookService.getBooks().size());
        ModelMap modelMap = new ModelMap();
        String viewName = bookController.displayAll(modelMap);
//        Assert.assertThat((List<Book>) modelMap.get("bookList"), is(bookList));
//        Assert.assertEquals(1,bookService.getBooks().size());
//        Assert.assertEquals(viewName,"bookShop");



        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookShop"))
                .andExpect(forwardedUrl("/WEB-INF/views/bookShop.jsp"));

        verify(bookService, times(1)).getBooks();
//        verifyNoMoreInteractions(bookService);
    }
}
