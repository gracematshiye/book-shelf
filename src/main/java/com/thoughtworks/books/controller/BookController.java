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

    private final String BOOK_NAME = "Java";
    private final String BOOK_ISBN = "boo-101";
    private final String BOOK_DESCRIPTION = "learn the fundamentals of OOP in java";
    private final BigDecimal BOOK_PRICE = new BigDecimal(123);

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String displayAll(ModelMap modelMap) {

        Book book = new Book(BOOK_NAME, BOOK_ISBN, BOOK_DESCRIPTION, BOOK_PRICE);
        bookService.addBook(book);

        List<Book> books = this.bookService.getBooks();

        modelMap.addAttribute("books", books);

        return "bookShop";
    }
}
