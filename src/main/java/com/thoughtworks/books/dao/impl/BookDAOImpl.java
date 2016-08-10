package com.thoughtworks.books.dao.impl;

import com.thoughtworks.books.dao.BookDao;
import com.thoughtworks.books.entity.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {


    private SessionFactory sessionFactory;

    @Autowired
    public BookDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getBooks() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Book");

        return query.list();
    }
}

