package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST)
    public String addBook(@ModelAttribute("person") Book book){

        if(book.getId() == 0){
            //new person, add it
            this.bookService.addBook(book);
        }

        return "bookShop";

    }
}
