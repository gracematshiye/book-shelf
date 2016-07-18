package com.thoughtworks.books.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BookTest {

    private Book book1;
    private Book book2;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("Java OOP", "1-5555-t166-0", "Java Book", new BigDecimal(150));
        book2 = new Book("Java 1", "1-5555-t165-0", "Java Book version 12", new BigDecimal(100));
    }

    @Test
    public void testBookEqualsItself() throws Exception {
        Assert.assertTrue(book1 == book1);
    }

    @Test
    public void testTwoBooksWithDifferentDescriptionShouldNotBeEqual() throws Exception {
        Assert.assertNotEquals(book1, book2);
    }

    @Test
    public void testBookIsNotNull() throws Exception {
        Assert.assertNotEquals(book1, null);
    }

    @Test
    public void testBookNotEqualToAnObjectOfDifferentType() throws Exception {
        Object object = new Object();
        Assert.assertNotEquals(book1, object);
    }

    @Test
    public void testEqualBooksHaveSameHashCode() throws Exception {
        book2 = book1;
        Assert.assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    public void testUnEqualBooksHaveDifferentHashCode() throws Exception {
        Assert.assertNotEquals(book1.hashCode(), book2.hashCode());
    }
}