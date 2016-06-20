package com.thoughtworks.books.service;

import com.thoughtworks.books.entity.Book;

import java.util.List;

public interface BookService {

    public void addBook(Book book);
    public List<Book> getBooks();
}
