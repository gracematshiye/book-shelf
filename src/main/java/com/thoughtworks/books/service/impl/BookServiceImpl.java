package com.thoughtworks.books.service.impl;

import com.thoughtworks.books.dao.BookDao;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDAO;

    @Autowired
    public BookServiceImpl(BookDao bookDAO){
        this.bookDAO = bookDAO;
    }

    public BookServiceImpl() {

    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    @Transactional
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }
}
