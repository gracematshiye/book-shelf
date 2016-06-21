package com.thoughtworks.books.dao;


import com.thoughtworks.books.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


public class BookDaoTest {

    private Book book;

    @Autowired
    private BookDAO bookDAO;

    private final String BOOK_NAME = "Java";
    private final String BOOK_ISBN = "boo-101";
    private final String BOOK_DESCRIPTION = "learn the fundamentals of OOP in java";
    private final BigDecimal BOOK_PRICE = new BigDecimal(123);

    @Before
    public void setUp() {

        book = new Book();

        book.setName(BOOK_NAME);
        book.setIsbn(BOOK_ISBN);
        book.setDescription(BOOK_DESCRIPTION);
        book.setPrice(BOOK_PRICE);
    }

    @Test
    public void testAddAndGetBook() throws Exception {

    }


    @Test
    public void testBookNotNull() throws Exception {
        Assert.assertNotNull(book);
    }

    @Test
    public void testBookElementsNotNull() throws Exception {

        Assert.assertEquals(BOOK_NAME, book.getName());
        Assert.assertEquals(BOOK_ISBN, book.getIsbn());
        Assert.assertEquals(BOOK_DESCRIPTION, book.getDescription());
        Assert.assertEquals(BOOK_PRICE, book.getPrice());
    }
}
