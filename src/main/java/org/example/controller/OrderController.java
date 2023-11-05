package org.example.controller;

import org.example.models.Cart;
import org.example.models.CartProduct;
import org.example.models.User;
import org.example.util.*;
import org.example.view.OrdersPage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrderController {
    private final  HomeController homeController;
    private final OrdersPage ordersPage;
    public OrderController(HomeController homeController) {
        this.homeController = homeController;
        this.ordersPage = new OrdersPage();
    }


    public void checkout() {
        ArrayList<Cart> cart = LoadUtils.getCart();

        try{
            FileWriter csv = new FileWriter(FileUtil.getOrdersFile(),true);
            int id = (int) (Math.random()*100);

            for (Cart cartProduct:cart){
                if(UserUtil.getLoggedUser().getId() == cartProduct.getUserid()){
                    csv.append("\n");
                    csv.append(id+","+cartProduct.getTitle()+","+cartProduct.getCount()+","+ StringUtil.STATUSP+","+UserUtil.getLoggedUser().getId());
                    cart.remove(cartProduct);
                }
            }
            csv.flush();
            csv.close();
            LoadUtils.logoutCartLoad(cart);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cart = null;
        LoadUtils.setCart(cart);
    }

    public void printOrders() {
        OrdersPage.printOrders();
        try {
            int choice = AppInput.enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 99){
                homeController.printMenu();
            } else {
                invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
            }
        } catch (AppException e) {
            invalidChoice(e);
        }
    }

    private void invalidChoice(AppException e) {
        System.out.println(e.getMessage());
    }
}
