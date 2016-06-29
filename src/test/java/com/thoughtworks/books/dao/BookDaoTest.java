package com.thoughtworks.books.dao;


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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/webapp/resources/spring-servlet-dao-test.xml")
@Transactional
@Rollback(true)
public class BookDaoTest {

    @Autowired
    private BookDAO bookDAO;

    private Book book;

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
        book = new Book("Java", "boo-101", "learn the fundamentals of OOP in java", new BigDecimal(123));
    }

    @Test
    public void testAddBook() throws Exception {
        try {
            session.beginTransaction();
            Assert.assertEquals(0, session.createQuery("from Book").list().size());

            bookDAO.addBook(book);

            Assert.assertEquals(1, session.createQuery("from Book").list().size());

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Could not save book");
        }
    }

    @Test
    public void testGetBook() throws Exception {
        try {
            assertEquals(0, bookDAO.getBooks().size());

            bookDAO.addBook(book);
            assertEquals(1, bookDAO.getBooks().size());

            List<Book> bookList = bookDAO.getBooks();

            Assert.assertEquals(book.getName(), bookList.get(0).getName());
            Assert.assertEquals(book.getIsbn(), bookList.get(0).getIsbn());
            Assert.assertEquals(book.getDescription(), bookList.get(0).getDescription());
            Assert.assertEquals(book.getPrice(), bookList.get(0).getPrice());

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Could not retrieve book");
        }
    }
}
