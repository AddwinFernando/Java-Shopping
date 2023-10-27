package org.example.controller;

import org.example.models.Product;
import org.example.util.LoadUtils;
import org.example.view.ProductsPage;

import java.util.ArrayList;

public class ProductController {
    private final HomeController homeController;
    private final ProductsPage productsPage;

    public ProductController(HomeController homeController) {
        this.homeController = homeController;
        this.productsPage = new ProductsPage();
    }

    public void showProducts(int catId) {
        ArrayList<Product> products = LoadUtils.getProducts();
        ArrayList<Product> catProducts = new ArrayList<>();
        for(Product product:products){
            if(product.getCategory().getId()==catId){
                catProducts.add(product);
            }
        }
        productsPage.printProducts(catProducts);
    }

}
