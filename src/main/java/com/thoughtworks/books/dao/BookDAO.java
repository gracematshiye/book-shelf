package com.thoughtworks.books.dao;

import com.thoughtworks.books.entity.Book;

import java.util.List;


public interface BookDAO {
    List<Book> getBooks();

}
