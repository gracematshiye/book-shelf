package com.thoughtworks.books.dao.impl;

import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(book);

        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getBooks() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.createQuery("from Book").list();
    }
}

