package com.thoughtworks.books.dao;

import com.thoughtworks.books.entity.Book;
import org.hibernate.SessionFactory;

import java.util.List;


public interface BookDAO {

    public void addBook(Book book);
    public List<Book> getBooks();

    void setSessionFactory(SessionFactory sessionFactory);
}
