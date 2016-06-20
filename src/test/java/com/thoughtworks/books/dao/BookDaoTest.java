package com.thoughtworks.books.dao;


import com.thoughtworks.books.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
public class BookDaoTest {

    private Book book;
    private BookDAO bookDAO;

    private String name = "Java";
    private String isbn = "boo-101";
    private String description = "learn java";
    private BigDecimal price = new BigDecimal(123);

    @Before
    public void setUp() {

        book = new Book();

        book.setName(name);
        book.setIsbn(isbn);
        book.setDescription(description);
        book.setPrice(price);
    }

    @Test
    public void testAddBook() throws Exception {

    }

    @Test
    public void testGetBooks() throws Exception {

    }

    @Test
    public void testBookNotNull() throws Exception {
        Assert.assertNotNull(book);
    }

    @Test
    public void testBookElementsNotNull() throws Exception {

        Assert.assertEquals(name, book.getName());
        Assert.assertEquals(isbn, book.getIsbn());
        Assert.assertEquals(description, book.getDescription());
        Assert.assertEquals(price, book.getPrice());
    }
}
