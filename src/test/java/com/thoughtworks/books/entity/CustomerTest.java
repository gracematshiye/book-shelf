package com.thoughtworks.books.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private Customer customer;
    private Customer customer1;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Hlulani", "Chauke", "0799999999", "h@mail.com", "200 khumalo street, ivory park");
        customer1 = new Customer("Grace", "Matshiye" ,"0788888888", "g@mail.com", "sosha block A");

    }

    @Test
    public void generateOderNumber() throws Exception {
        String orderNumber = (customer1.getName().substring(0, 3) + "-" + customer1.getSurname().substring(0, 3)).toUpperCase();

        Assert.assertEquals("GRA-MAT", orderNumber);
    }

    @Test
    public void testCustomerEqualsToItSelf() throws Exception {
        Assert.assertEquals(customer, customer);
    }

    @Test
    public void testCustomerNoNull() throws Exception {
        Assert.assertNotNull(customer);
    }

    @Test
    public void testCustomerNotEqualToAnObjectOfDifferentTyp() throws Exception {
        Object object = new Object();

        Assert.assertNotEquals(customer, object);
    }

    @Test
    public void testUnEqualCustomersHaveDifferentHashCode() throws Exception {
        Assert.assertNotEquals(customer.hashCode(), customer1.hashCode());
    }

    @Test
    public void testEqualCustomersHaveSameHashCode() throws Exception {
        customer = customer1;
        Assert.assertEquals(customer.hashCode(), customer1.hashCode());
    }
}
