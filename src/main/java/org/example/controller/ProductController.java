package org.example.controller;

import org.example.App;
import org.example.models.Category;
import org.example.models.Product;
import org.example.util.AppException;
import org.example.util.AppInput;
import org.example.util.LoadUtils;
import org.example.util.StringUtil;
import org.example.view.ProductsPage;

import java.util.ArrayList;

public class ProductController {
    private final HomeController homeController;
    private final ProductsPage productsPage;

    private  final CartController cartController;

    private int catId = 0;

    public ProductController(HomeController homeController) {
        this.homeController = homeController;
        this.productsPage = new ProductsPage();
        this.cartController = new CartController(homeController);
    }

    public void showProducts(int catId) {
        ArrayList<Product> products = LoadUtils.getProducts();
        ArrayList<Product> catProducts = new ArrayList<>();
        if(catId!=0){
            for(Product product:products){
                if(product.getCategory().getId()==catId){
                    catProducts.add(product);
                }
            }
            products = catProducts;
        }
        productsPage.printProducts(products);

        try{
            int choice = AppInput.enterInt(StringUtil.ENTER_CHOICE);
            int validId = 0;
            if (choice == 99){
                homeController.printMenu();
            } else {
                for(Product product:products){
                    if(product.getId()==choice){
                        validId = choice;
                        break;
                    }
                }
                if(validId!=0) {
                    cartController.addToCart(validId);
                    showProducts(catId);
                } else{
                    invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
                }
            }

        } catch (AppException e) {
            invalidChoice(e);
        }
    }

    private void invalidChoice(AppException e) {
        System.out.println(e.getMessage());
        showProducts(catId);
    }

}
