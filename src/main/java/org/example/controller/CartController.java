package org.example.controller;

import org.example.App;
import org.example.models.*;
import org.example.util.*;
import org.example.view.CartPage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CartController {
    private final HomeController homeController;
    private final CartPage cartPage;
    private final OrderController orderController;

    public CartController(HomeController homeController) {
        this.homeController = homeController;
        this.cartPage = new CartPage();
        this.orderController = new OrderController(homeController);
    }

    public void printCart() {
        User loggedInUser = UserUtil.getLoggedUser();

        cartPage.printCart(loggedInUser.getId());

        try {
            int choice = AppInput.enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 99) {
                homeController.printMenu();
            } else if (choice == 88) {
                checkout();
                homeController.printMenu();
            } else {
                invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
            }
        } catch (AppException e) {
            invalidChoice(e);
        }

    }

    private void invalidChoice(AppException appException) {
        System.out.println(appException.getMessage());
        homeController.printMenu();
    }

    public void addToCart(int validId) {
        User loggedInUser = UserUtil.getLoggedUser();
        ArrayList<Cart> Cart = LoadUtils.getCart();
        ArrayList<Product> products = LoadUtils.getProducts();
        Product userProduct = null;
        boolean isFound = false;
        Cart currCartProd = null;
        for (Product product : products) {
            if (product.getId() == validId) {
                userProduct = product;
                break;
            }
        }

        for(Cart cartProd:Cart){
            if (cartProd.getId() == userProduct.getId()){
                currCartProd = cartProd;
                isFound = true;
            }
        }
        if (!isFound){
            Cart.add(new Cart(loggedInUser.getId(), userProduct.getId(),userProduct.getTitle(),1,userProduct.getPrice()));
        } else {
            currCartProd.setCount(currCartProd.getCount()+1);
            currCartProd.setPrice((int) (currCartProd.getPrice()* currCartProd.getCount()));
        }
        LoadUtils.setCart(Cart);
        LoadUtils.logoutCartLoad(Cart);
        UserUtil.setLoggedUser(loggedInUser);
    }

    private void checkout() {
        orderController.checkout();
    }
}
