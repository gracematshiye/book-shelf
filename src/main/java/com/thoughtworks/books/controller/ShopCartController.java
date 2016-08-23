package com.thoughtworks.books.controller;

import com.thoughtworks.books.entity.Book;
import com.thoughtworks.books.service.BookService;
import com.thoughtworks.books.service.ShoppingCartService;
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
    private ShoppingCartService shoppingCartService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/shop-cart/{id}")
    public String addToCart(@PathVariable("id") int id, ModelMap modelMap) {

        List<Book> books = this.bookService.getBooks();

        for (int i = 0; i < books.size(); i++) {

            if (id == books.get(i).getId()) {
                shoppingCartService.addToCart(books.get(i));
            }
        }

        modelMap.addAttribute("cartSize", this.shoppingCartService.getShopCartSize());
        return "redirect:/books";
    }

    @RequestMapping(value = "/shop-cart/cart-list", method = RequestMethod.GET)
    public String cartList(ModelMap modelMap) {

        modelMap.addAttribute("cartList", shoppingCartService.getCartList());
        modelMap.addAttribute("cartSize", shoppingCartService.getShopCartSize());
        modelMap.addAttribute("cartTotal", shoppingCartService.getCartTotal());

        return "cart-list";
    }

    @RequestMapping(value = "/shop-cart/cart-remove/{id}")
    public String removeItem(@PathVariable("id") int id, ModelMap modelMap) {

        shoppingCartService.removeItemFromCart(id);
        modelMap.addAttribute("cartList", shoppingCartService.getCartList());

        return "redirect:/shop-cart/cart-list";
    }

    @RequestMapping(value = "/shop-cart/cart-empty")
    public String clearCart(ModelMap modelMap) {

        shoppingCartService.clearCart();
        modelMap.addAttribute("cartList", shoppingCartService.getCartList());

        return "redirect:/shop-cart/cart-list";
    }

    @RequestMapping(value = "/shop-cart/cart-checkout")
    public String checkout(ModelMap modelMap) {

        modelMap.addAttribute("cartSize", shoppingCartService.getShopCartSize());
        return "customer-details";
    }
}
