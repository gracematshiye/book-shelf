package com.thoughtworks.books;

import com.thoughtworks.books.entity.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {


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

}
