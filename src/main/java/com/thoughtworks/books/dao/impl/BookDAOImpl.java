package com.thoughtworks.books.dao.impl;

import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.orm.hibernate3.SessionFactoryUtils.getSession;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        getSession().persist(book);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getBooks() {
        return getSession().createCriteria(Book.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();

        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

}
