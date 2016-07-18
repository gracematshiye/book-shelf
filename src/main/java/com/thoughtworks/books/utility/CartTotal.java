package com.thoughtworks.books.utility;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class CartTotal {

    @Autowired
    private ShoppingCartService shoppingCartService;

    public BigDecimal total(){

        BigDecimal total = new BigDecimal(0);

        List<Book> cartList = shoppingCartService.getCartList();

        for (int i = 0; i < cartList.size(); i++) {
            total = total.add(cartList.get(i).getPrice());
        }
        return total;
    }
}
