package com.thoughtworks.books.service.impl;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private BookService bookService = new BookServiceImpl();

    private List<Book> bookList = new ArrayList<>();

    @Override
    public void addToCart(Book book) {
        bookList.add(book);
    }

    @Override
    public List<Book> getCartList() {
        return bookList;
    }

    public int getShopCartSize() {
        return bookList.size();
    }

    @Override
    public BigDecimal getCartTotal() {

        BigDecimal cartTotal = new BigDecimal(0);

        if (getCartList().size() > 0) {
            for (int i = 0; i < getCartList().size(); i++) {
                cartTotal = cartTotal.add(getCartList().get(i).getPrice());
            }
        }
        return cartTotal;
    }

    @Override
    public void removeItemFromCart(int id) {

        for (int i = 0; i < getCartList().size(); i++) {
            if (id == getCartList().get(i).getId()) {
                getCartList().remove(i);
                break;
            }
        }
    }

    @Override
    public void clearCart() {
        getCartList().clear();
    }

}


