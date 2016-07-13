package com.thoughtworks.books.service;


import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCart {

    @Autowired
    private BookService bookService = new BookServiceImpl();

    private BigDecimal cartTotal = new BigDecimal(0);
    private List<Book> bookList = new ArrayList<>();


    public int getShopCartCount() {
        return bookList.size();
    }

    @Transactional
    public void addToCart(Book book) {
        bookList.add(book);
    }

    @Transactional
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

    public String getBookName(Book book) {
        return book.getName();
    }
}
