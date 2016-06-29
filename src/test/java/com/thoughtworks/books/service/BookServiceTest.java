package com.thoughtworks.books.service;


import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.impl.BookServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.annotation.Rollback;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@Rollback(true)
public class BookServiceTest {

    @Mock
    private BookDAO bookDAO;

    @Mock
    private List<Book> books = new ArrayList<Book>();

    @InjectMocks
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = new BookServiceImpl();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddBook() {
        try {

            doNothing().when(bookDAO).addBook(any(Book.class));
            bookService.addBook(any(Book.class));
            verify(bookDAO, atLeastOnce()).addBook(any(Book.class));

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not save book");
        }
    }


    @Test
    public void testGetBooks() throws Exception {
        try {

            when(bookDAO.getBooks()).thenReturn(books);
            assertEquals(bookService.getBooks(), books);
            verify(bookDAO, atLeastOnce()).getBooks();

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not get book");
        }
    }

}
