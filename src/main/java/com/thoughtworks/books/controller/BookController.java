package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String displayAll(ModelMap modelMap) {

        List<Book> books = this.bookService.getBooks();

        modelMap.addAttribute("books", books);

        return "bookShop";
    }
}
