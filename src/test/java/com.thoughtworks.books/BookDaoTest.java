package com.thoughtworks.books;

import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import org.jmock.auto.Mock;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {

    @Mock
    private BookDAO bookDAO;

    @Test
    @Transactional
    public void testAddBook() throws Exception {
        Book book = new Book("JAVA", "book-101", "learn java", new BigDecimal(100));
        bookDAO.addBook(book);

        List<Book> list = bookDAO.getBooks();

        Assert.assertEquals(book.getId(), list.get(0).getId());
        Assert.assertEquals(book.getName(), list.get(0).getName());
        Assert.assertEquals(book.getIsbn(), list.get(0).getIsbn());
        Assert.assertEquals(book.getDescription(), list.get(0).getDescription());
        Assert.assertEquals(book.getPrice(), book.getPrice());
    }

//    @Test
//    public void testGetBooks() throws Exception {
//        Book book = new Book("JAVA", "book-101", "learn java", new BigDecimal(100));
//        List<Book> list = bookDAO.addBook(book);
//
//        Assert.assertEquals(book.getName(), list.get(0).getName());
//        Assert.assertEquals(book.getIsbn(), list.get(0).getIsbn());
//        Assert.assertEquals(book.getDescription(), list.get(0).getDescription());
//        Assert.assertEquals(book.getPrice(), book.getPrice());
//    }
}
