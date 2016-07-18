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

    private List<Book> bookList = new ArrayList<>();

    @Autowired
    private BookService bookService = new BookServiceImpl();

    @Override
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
    public BigDecimal cartTotal() {
        BigDecimal total = new BigDecimal(0);

        List<Book> cartList = getCartList();

        for (int i = 0; i < cartList.size(); i++) {
            total = total.add(cartList.get(i).getPrice());
        }
        return total;
    }

    @Override
    public void removeFromCart(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (id == bookList.get(i).getId()) {
                bookList.remove(bookList.get(i));
            }
        }
    }

}


