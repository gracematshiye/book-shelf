package com.thoughtworks.books.service.impl;


import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }
}
