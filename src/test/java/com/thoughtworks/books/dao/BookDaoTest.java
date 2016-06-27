package com.thoughtworks.books.dao;


import com.thoughtworks.books.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/webapp/resources/spring-servlet-dao-test.xml")
@Transactional
public class BookDaoTest {

    @Autowired
    private BookDAO bookDAO;

    private Book book;

    private List<Book> bookList = new ArrayList<>();

    @Before
    public void setUp() {

        book = new Book();

        book.setName(BOOK_NAME);
        book.setIsbn(BOOK_ISBN);
        book.setDescription(BOOK_DESCRIPTION);
        book.setPrice(BOOK_PRICE);
    }

    @Test
    public void testBookNotNull() {
       try {
           Assert.assertNotNull(book);

       } catch (Exception ex){
           ex.printStackTrace();
           fail("Book is equal to null");
       }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testAddBook() throws Exception {
        try {
            bookDAO.addBook(book);
            bookList = bookDAO.getBooks();

            Assert.assertNotNull(bookList);

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not add book");
        }
    }

    @Test
    @Rollback(true)
    public void testGetBook() throws Exception {
        try {
            bookDAO.addBook(book);
            bookList = bookDAO.getBooks();

            Assert.assertEquals(book.getName(), bookList.get(0).getName());
            Assert.assertEquals(book.getIsbn(), bookList.get(0).getIsbn());
            Assert.assertEquals(book.getDescription(), bookList.get(0).getDescription());
            Assert.assertEquals(book.getPrice(), bookList.get(0).getPrice());

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not get book");
        }
    }


    private final String BOOK_NAME = "Java";
    private final String BOOK_ISBN = "boo-101";
    private final String BOOK_DESCRIPTION = "learn the fundamentals of OOP in java";
    private final BigDecimal BOOK_PRICE = new BigDecimal(123);
}
