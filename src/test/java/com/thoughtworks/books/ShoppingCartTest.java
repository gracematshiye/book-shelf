package com.thoughtworks.books;

import com.thoughtworks.books.entity.Book;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;
    @Before
    public void setUp() throws Exception {
        shoppingCart = new ShoppingCart();

    }


    @Test
    public void testShopCartIsEmpty() throws Exception {

        Assert.assertEquals(0, shoppingCart.getShopCartCount());

    }

    @Test
    public void itShouldAddBookToCartThenReturnOne() throws Exception {
        Book book = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(4554));
        shoppingCart.addToCart(book);

        Assert.assertEquals(1, shoppingCart.getShopCartCount());

    }

    @Test
    public void itShouldAddTwoBooksToCartThenReturnTwo() throws Exception {
        Book book1 = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(4554));
        Book book2 = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(4554));
        shoppingCart.addToCart(book1);
        shoppingCart.addToCart(book2);

        Assert.assertEquals(2, shoppingCart.getShopCartCount());
    }

    @Test
    public void addOneBookToCartListThenReturnBook() throws Exception {
        Book book = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(4554));
        shoppingCart.addToCart(book);
        List<Book> cartList = new ArrayList<>();
        cartList.add(book);

        Assert.assertEquals(cartList, shoppingCart.getCartList());
    }

    @Test
    public void testAddOneBookReturnTotalPrice() throws Exception {
        Book book = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(100));
        shoppingCart.addToCart(book);
        Assert.assertEquals(new BigDecimal(100), shoppingCart.getCartTotal());
    }

    @Test
    public void testAddTwoBooksReturnTotalPrice() throws Exception {
        Book book1 = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(100));
        Book book2 = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(100));
        shoppingCart.addToCart(book1);
        shoppingCart.addToCart(book2);

        Assert.assertEquals(new BigDecimal(200), shoppingCart.getCartTotal());
    }


    @Test
    public void testAddBook() throws Exception {

    }
}
