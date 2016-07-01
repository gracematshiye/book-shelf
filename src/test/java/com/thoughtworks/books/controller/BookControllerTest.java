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


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/webapp/resources/spring-applicationContext-controller.xml")
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

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        bookList.add(first);

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver).build();
        when(bookService.getBooks()).thenReturn(bookList);

    }

    // Verify that name of the rendered view is ‘bookShop’
    @Test
    public void testDisplayMethodIsCalled() throws Exception {

        String viewName = controller.displayAll(new ModelMap());
        Assert.assertEquals("bookShop", viewName);

    }

    // Verify that the getBooks method was called
    @Test
    public void testGetBooksMethodFromServiceIsCalled() throws Exception {

        Assert.assertEquals(bookList,bookService.getBooks());
        verify(bookService, times(1)).getBooks();


    }

     // Verify that the HTTP status code is 200.
    @Test
    public void testVerifyTheHTTPStatusIsOkay() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

    }

    //Verify that the size of the book list is 1
    @Test
    public void testBookListHasOneElement() throws Exception {

      try {
          mockMvc.perform(get("/"))
                  .andExpect(model().attribute("books", hasSize(1)));

      } catch (Exception e){
          e.printStackTrace();
          fail("Wrong URL");
      }

    }

    //Verify that the book list contains the correct items
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

    //Verify that the request is forwarded to url ‘/WEB-INF/views/bookShop.jsp
    @Test
    public void testRequestIsForwardedToUrl() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(forwardedUrl("/WEB-INF/views/bookShop.jsp"));

    }
}
