package com.thoughtworks.books.service;

import com.thoughtworks.books.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-servlet.xml")
@Transactional
public class BookServiceTest {

    private Book book;

    private final String BOOK_NAME = "Java";
    private final String BOOK_ISBN = "boo-101";
    private final String BOOK_DESCRIPTION = "learn the fundamentals of OOP in java";
    private final BigDecimal BOOK_PRICE = new BigDecimal(123);

    @Autowired
    private BookService bookService;


    @Before
    public void setUp() {

        book = new Book();

        book.setName(BOOK_NAME);
        book.setIsbn(BOOK_ISBN);
        book.setDescription(BOOK_DESCRIPTION);
        book.setPrice(BOOK_PRICE);
    }

    @Test
    public void testBookListEqualZero() throws Exception {
        List<Book> bookList = bookService.getBooks();
        Assert.assertEquals(0 , bookList.size());
    }

    @Test
    public void testBookListEqualOne() throws Exception {
        bookService.addBook(book);

        List<Book> bookList = bookService.getBooks();
        Assert.assertEquals(1 , bookList.size());
    }

    @Test
    public void testAddBookReturnBook() throws Exception {
        bookService.addBook(book);

        List<Book> bookList = bookService.getBooks();

        Assert.assertEquals(book.getName(), bookList.get(0).getName());
        Assert.assertEquals(book.getIsbn(), bookList.get(0).getIsbn());
        Assert.assertEquals(book.getDescription(), bookList.get(0).getDescription());
        Assert.assertEquals(book.getPrice(), bookList.get(0).getPrice());
    }
}