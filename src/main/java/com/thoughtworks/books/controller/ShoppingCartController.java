package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/")
public class ShoppingCartController {

    @Autowired
    private ShoppingCart shoppingCart;

    @RequestMapping(value = "/shop-cart/{id}")
    public String addToShopCart(@PathVariable("id") int id, ModelMap modelMap) {

        shoppingCart.addToCart(new Book());

        modelMap.addAttribute("cartSize", this.shoppingCart.getShopCartCount());
        return "bookShop";
    }

}
