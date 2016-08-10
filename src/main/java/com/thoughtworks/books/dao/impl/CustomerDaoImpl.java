package com.thoughtworks.books.dao.impl;

import com.thoughtworks.books.dao.CustomerDao;
import com.thoughtworks.books.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Customer");

        return query.list();
    }
}
