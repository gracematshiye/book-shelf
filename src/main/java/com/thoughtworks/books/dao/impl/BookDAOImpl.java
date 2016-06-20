package com.thoughtworks.books.dao.impl;

import com.thoughtworks.books.dao.BookDAO;
import com.thoughtworks.books.entity.Book;
import org.hibernate.Query;
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

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        getSession().save(book);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getBooks() {
        //return getSession().createCriteria(Book.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("select * from Book");
        List<Book> bookList = q.list();
        return bookList;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();

        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

}
