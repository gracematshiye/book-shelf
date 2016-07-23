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
public interface ShoppingCartService {

    int getShopCartSize();

    void addToCart(Book book);

    List<Book> getCartList();

    void removeItemFromCart(int id);

    BigDecimal getCartTotal();

    void clearCart();
}
