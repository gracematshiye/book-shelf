package com.thoughtworks.books.service.ShoppingCartsService;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.ShoppingCartService;
import com.thoughtworks.books.service.impl.BookServiceImpl;
import com.thoughtworks.books.service.impl.ShoppingCartServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServiceTest {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        shoppingCartService = new ShoppingCartServiceImpl();
        bookService = new BookServiceImpl();
    }

    /**
     * Check if shoppingCart is empty
     **/
    @Test
    public void testShopCartIsEmpty() throws Exception {
        Assert.assertEquals(0, shoppingCartService.getShopCartCount());
    }

    /**
     * Add book into cart and check if the size is 1
     */
    @Test
    public void itShouldAddBookToCartThenReturnOne() throws Exception {
        Book book = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(4554));
        shoppingCartService.addToCart(book);

        Assert.assertEquals(1, shoppingCartService.getShopCartCount());
    }

    /**
     * Add two books into cart and check if the size is 2
     */
    @Test
    public void itShouldAddTwoBooksToCartThenReturnTwo() throws Exception {
        Book book1 = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(4554));
        Book book2 = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(4554));
        shoppingCartService.addToCart(book1);
        shoppingCartService.addToCart(book2);

        Assert.assertEquals(2, shoppingCartService.getShopCartCount());
    }

    /**
     * Add book into cart and return it
     */
    @Test
    public void addOneBookToCartListThenReturnBook() throws Exception {
        Book book = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(4554));
        shoppingCartService.addToCart(book);
        List<Book> cartList = new ArrayList<>();
        cartList.add(book);

        Assert.assertEquals(cartList, shoppingCartService.getCartList());
    }

    /**
     * Add two books into cart and check if the size is 2, and then
     * Remove a book from cart and check if the size is 1
     */
    @Test
    public void testRemoveBookFromCartList() throws Exception {

        Book book = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(100));
        Book book1 = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(100));

        shoppingCartService.addToCart(book);
        shoppingCartService.addToCart(book1);

        Assert.assertEquals(2, shoppingCartService.getCartList().size());

        shoppingCartService.removeFromCart(book.getId());

        Assert.assertEquals(1, shoppingCartService.getCartList().size());
    }

    /**
     * Add book into cart and calculate the total
     */
    @Test
    public void testAddOneBookReturnTotalPrice() throws Exception {
        Book book = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(100));
        shoppingCartService.addToCart(book);

        Assert.assertEquals(new BigDecimal(100), shoppingCartService.cartTotal());
    }

    /**
     * Add two books into cart and calculate the total
     */
    @Test
    public void testAddTwoBooksReturnTotalPrice() throws Exception {
        Book book1 = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(100));
        Book book2 = new Book("java", "HHD-BF789DFS-SDF", "JAVA BOOK", new BigDecimal(100));
        shoppingCartService.addToCart(book1);
        shoppingCartService.addToCart(book2);

        Assert.assertEquals(new BigDecimal(200), shoppingCartService.cartTotal());
    }
}
