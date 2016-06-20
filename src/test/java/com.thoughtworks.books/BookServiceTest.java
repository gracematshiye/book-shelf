package com.thoughtworks.books;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testRetrieveBooks() throws Exception {
        List<Book> list = bookService.getBooks();

        Assert.assertNotNull(list);

    }
}
