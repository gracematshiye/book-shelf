package com.thoughtworks.books;


import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

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
