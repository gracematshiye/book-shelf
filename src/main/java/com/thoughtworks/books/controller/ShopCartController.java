package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.ShoppingCartService;
import com.thoughtworks.books.service.impl.BookServiceImpl;
import com.thoughtworks.books.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ShopCartController {

    @Autowired
    private BookService bookService = new BookServiceImpl();

    @Autowired
    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    @RequestMapping(value = "/shop-cart/{id}")
    public String addToCart(@PathVariable("id") int id, ModelMap modelMap) {

        List<Book> books = this.bookService.getBooks();

        for (int i = 0; i < books.size(); i++) {
            if (id == books.get(i).getId()){
                this.shoppingCartService.addToCart(books.get(i));
            }
        }
        modelMap.addAttribute("cartSize", this.shoppingCartService.getShopCartCount());

        return "redirect:/books";
    }

    @RequestMapping(value = "/shop-cart/remove/{id}")
    public String removeCartItem(@PathVariable("id") int id) {

        this.shoppingCartService.removeFromCart(id);

        return "redirect:/shop-cart/cart-list";
    }

    @RequestMapping(value = "/shop-cart/empty-cart")
    public String emptyCart(ModelMap modelMap){

        this.shoppingCartService.getCartList().clear();

        return "redirect:/shop-cart/cart-list";
    }

    @RequestMapping(value = "/shop-cart/cart-list", method = RequestMethod.GET)
    public String cartList(ModelMap modelMap) {

        modelMap.addAttribute("cartList", this.shoppingCartService.getCartList());
        modelMap.addAttribute("cartTotal", this.shoppingCartService.cartTotal());
        modelMap.addAttribute("cartSize", this.shoppingCartService.getShopCartCount());

        return "cart-list";
    }
}
