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

    public int getShopCartCount();

    public void addToCart(Book book);

    public List<Book> getCartList();

    public void removeFromCart(int id);

    public BigDecimal cartTotal();
}
