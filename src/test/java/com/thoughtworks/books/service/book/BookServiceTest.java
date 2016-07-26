package com.thoughtworks.books.service.book;

import com.thoughtworks.books.dao.BookDao;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookDao bookDAO;

    @Mock
    private List<Book> bookList = new ArrayList<Book>();

    @InjectMocks
    private BookService bookService = new BookServiceImpl();


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Add book and verify if the addBook() method was called
     */
    @Test
    public void testAddOneBook() throws Exception {
        doNothing().when(bookDAO).addBook(any(Book.class));
        bookService.addBook(any(Book.class));
        verify(bookDAO, atLeastOnce()).addBook(any(Book.class));
    }

    /**
     * Check that getBooks() method return bookList when it is called
     */
    @Test
    public void testGetAllBooks() throws Exception {
        when(bookDAO.getBooks()).thenReturn(bookList);

        Assert.assertEquals(bookService.getBooks(), bookList);
        bookService.getBooks();
        verify(bookDAO, atLeastOnce()).getBooks();
    }
}
