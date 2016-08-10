package com.thoughtworks.books.dao.customer;

import com.thoughtworks.books.dao.CustomerDao;
import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/webapp/resources/applicationContext-customer-dao-test.xml")
@Transactional
@Rollback(true)
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDAO;

    @Autowired
    private SessionFactory sessionFactory;

    private Customer customer;

    private Session session;

    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
        List<Book> cartList = new ArrayList<>();
        customer = new Customer("Hlulani", "Chauke", "0799999999", "h@mail.com", "200 khumalo street, ivory park");
    }

    @Test
    public void testAddCustomer() throws Exception {
        session.beginTransaction();
        Assert.assertEquals(0, session.createQuery("from Customer").list().size());

        session.save(customer);
        Assert.assertEquals(1, session.createQuery("from Customer").list().size());
    }

    @Test
    public void testGetCustomers() throws Exception {
        session.beginTransaction();

        session.save(customer);

        Assert.assertEquals(1, session.createQuery("from Customer").list().size());

        List<Customer> customerList = session.createQuery("from Customer").list();

        Assert.assertEquals(customer.getName(), customerList.get(0).getName());
        Assert.assertEquals(customer.getSurname(), customerList.get(0).getSurname());
        Assert.assertEquals(customer.getContact(), customerList.get(0).getContact());
        Assert.assertEquals(customer.getEmail(), customerList.get(0).getEmail());
        Assert.assertEquals(customer.getAddress(), customerList.get(0).getAddress());
    }
}
