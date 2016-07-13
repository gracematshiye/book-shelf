package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ShoppingCart shoppingCart;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayAll(ModelMap modelMap) {


        List<Book> books = this.bookService.getBooks();
        modelMap.addAttribute("books", books);

        return "main";
    }

    @RequestMapping(value = "/shop-cart/{id}")
    public String addToCart(@PathVariable("id") int id, ModelMap modelMap) {

        shoppingCart.addToCart(new Book());

        List<Book> books = this.bookService.getBooks();
        modelMap.addAttribute("books", books);

        modelMap.addAttribute("cartSize", this.shoppingCart.getShopCartCount());
        return "main";
    }

}
