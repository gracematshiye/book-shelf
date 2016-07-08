package com.thoughtworks.books;

import com.thoughtworks.books.entity.Book;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void testShopCartIsEmpty() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        Assert.assertEquals(0, shoppingCart.getShopCartCount());

    }

    @Test
    public void itShouldAddBookToCartThenReturnOne() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        Book book = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(4554));
        shoppingCart.addToCart(book);

        Assert.assertEquals(1, shoppingCart.getShopCartCount());

    }

    @Test
    public void itShouldAddTwoBooksToCartThenReturnTwo() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        Book book1 = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(4554));
        Book book2 = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(4554));
        shoppingCart.addToCart(book1);
        shoppingCart.addToCart(book2);

        Assert.assertEquals(2, shoppingCart.getShopCartCount());
    }

    @Test
    public void addOneBookToCartListThenReturnBook() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        Book book = new Book("java", "HHD-BF789DFS-SDF","JAVA BOOK", new BigDecimal(4554));
        shoppingCart.addToCart(book);
        List<Book> cartList = new ArrayList<>();
        cartList.add(book);

        Assert.assertEquals(cartList, shoppingCart.getCartList());
    }

}
