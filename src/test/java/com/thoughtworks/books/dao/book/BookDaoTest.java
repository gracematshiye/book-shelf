package com.thoughtworks.books.dao.book;


import com.thoughtworks.books.dao.BookDao;
import com.thoughtworks.books.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/webapp/resources/applicationContext-book-dao-test.xml")
@Transactional
@Rollback(true)
public class BookDaoTest {

    @Autowired
    private BookDao bookDAO;

    @Autowired
    private SessionFactory sessionFactory;

    private Book book;

    private Session session;

    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
        book = new Book("Java", "book-101", "Learn java fundamentals in 21 days", new BigDecimal(123));
    }

    /**
     * Check if database state is 0, and then add a book using the addBook() method,
     * again check if database state is 1
     */
    @Test
    public void testAddBook() throws Exception {
        session.beginTransaction();
        Assert.assertEquals(0, session.createQuery("from Book").list().size());

        bookDAO.addBook(book);
        Assert.assertEquals(1, session.createQuery("from Book").list().size());
    }

    /**
     * Check if there are no books, if true, add a book using addBook() method, and then
     * check if the book was added.
     * check all book elements
     */
    @Test
    public void testGetBooks() throws Exception {
        Assert.assertEquals(0, bookDAO.getBooks().size());

        bookDAO.addBook(book);
        Assert.assertEquals(1, bookDAO.getBooks().size());

        List<Book> bookList = bookDAO.getBooks();

        Assert.assertEquals(book.getName(), bookList.get(0).getName());
        Assert.assertEquals(book.getIsbn(), bookList.get(0).getIsbn());
        Assert.assertEquals(book.getDescription(), bookList.get(0).getDescription());
        Assert.assertEquals(book.getPrice(), bookList.get(0).getPrice());
    }
}
