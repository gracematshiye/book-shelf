package com.thoughtworks.books.service;

import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/webapp/resources/spring-servlet-dao-test.xml")
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@WebAppConfiguration
public class BookServiceTest {

    @Autowired
    private BookService bookService;

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
    public void testBookListEqualEmpty() {

        try {
            bookList = bookService.getBooks();
            Assert.assertTrue(bookList.size() == 0);

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not test book equal to zero");
        }
    }

    @Test
    @Rollback(true)
    public void testBookListEqualOne() {
        try {
            bookService.addBook(book);
            bookList = bookService.getBooks();

            Assert.assertTrue(bookList.size() == 1);

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not test book equal to one");
        }
    }

    @Test
    @Rollback(true)
    public void testAddBook() {
        try {

            bookService.addBook(book);
            Assert.assertNotNull(bookService);

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not save book");
        }
    }

    @Test
    @Rollback(true)
    public void testGetBooks() throws Exception {
        try {
            bookService.addBook(book);
            bookList = bookService.getBooks();

            Assert.assertTrue(bookList.size() != 0);

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not get book");
        }
    }

    @Test
    @Rollback(true)
    public void testAddBookReturnBook() throws Exception {

        try {
            bookService.addBook(book);
            bookList = bookService.getBooks();

            Assert.assertTrue(bookList.size() != 0);

            Assert.assertEquals(book.getName(), bookList.get(0).getName());
            Assert.assertEquals(book.getIsbn(), bookList.get(0).getIsbn());
            Assert.assertEquals(book.getDescription(), bookList.get(0).getDescription());
            Assert.assertEquals(book.getPrice(), bookList.get(0).getPrice());

        } catch (Exception ex){
            ex.printStackTrace();
            fail("Could not test add book return book");
        }
    }

    private final String BOOK_NAME = "Java";
    private final String BOOK_ISBN = "boo-101";
    private final String BOOK_DESCRIPTION = "learn the fundamentals of OOP in java";
    private final BigDecimal BOOK_PRICE = new BigDecimal(123);

}
