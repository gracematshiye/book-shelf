package com.thoughtworks.books;

import com.thoughtworks.books.entity.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private BigDecimal cartTotal = new BigDecimal(0);

    private List<Book> bookList = new ArrayList<>();

    public int getShopCartCount() {
        return bookList.size();
    }

    public void addToCart(Book book) {

        bookList.add(book);
    }


    public List<Book> getCartList() {
        return bookList;
    }

    public BigDecimal getCartTotal() {

        if (bookList.size() > 0) {
            for (Book book : bookList) {
                cartTotal = cartTotal.add(book.getPrice());
            }
        }
        return cartTotal;
    }
}
