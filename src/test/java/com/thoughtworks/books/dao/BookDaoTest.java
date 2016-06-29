package com.thoughtworks.books.dao;


import com.thoughtworks.books.dao.BookDAO;
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
public class BookDaoTest {

    private Book book;

    private final String BOOK_NAME = "Java";
    private final String BOOK_ISBN = "boo-101";
    private final String BOOK_DESCRIPTION = "learn the fundamentals of OOP in java";
    private final BigDecimal BOOK_PRICE = new BigDecimal(123);

    @Autowired
    private BookDAO bookDAO;

    @Before
    public void setUp() {

        book = new Book();

        book.setName(BOOK_NAME);
        book.setIsbn(BOOK_ISBN);
        book.setDescription(BOOK_DESCRIPTION);
        book.setPrice(BOOK_PRICE);
    }

    @Test
    public void testBookAndItElementsNotNull() throws Exception {
        //test book not null
        Assert.assertNotNull(book);

        //test book element not null
        Assert.assertEquals(BOOK_NAME, book.getName());
        Assert.assertEquals(BOOK_ISBN, book.getIsbn());
        Assert.assertEquals(BOOK_DESCRIPTION, book.getDescription());
        Assert.assertEquals(BOOK_PRICE, book.getPrice());
    }

    @Test
    public void testAddAndGetBook() throws Exception {

        bookDAO.addBook(book);

        List<Book> bookList = bookDAO.getBooks();

        Assert.assertEquals(book.getName(), bookList.get(0).getName());
        Assert.assertEquals(book.getIsbn(), bookList.get(0).getIsbn());
        Assert.assertEquals(book.getDescription(), bookList.get(0).getDescription());
        Assert.assertEquals(book.getPrice(), bookList.get(0).getPrice());
    }
}
