package com.thoughtworks.books.service.impl;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private BookService bookService = new BookServiceImpl();


    private List<Book> bookList = new ArrayList<>();

    public int getShopCartCount() {
        return bookList.size();
    }

    @Override
    public void addToCart(Book book) {
        bookList.add(book);
    }

    @Override
    public List<Book> getCartList() {
        return bookList;
    }

    @Override
    public void removeItemFromCart(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (id == bookList.get(i).getId()){
                getCartList().remove(i);
                break;
            }
        }
    }

    @Override
    public BigDecimal getCartTotal() {

        BigDecimal cartTotal = new BigDecimal(0);

        if (bookList.size() > 0) {
            for (int i = 0; i < bookList.size(); i++) {
                cartTotal = cartTotal.add(bookList.get(i).getPrice());
            }
        }
        return cartTotal;
    }

    @Override
    public void clearCart() {
        getCartList().clear();
    }

}


