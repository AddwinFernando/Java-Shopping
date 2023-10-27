package org.example.view;

import org.example.models.Product;
import org.example.util.StringUtil;

import java.util.ArrayList;

public class ProductsPage{
    public void printProducts(ArrayList<Product> catProducts) {
        try {
            System.out.println("#---------------------#");
            System.out.println(StringUtil.PRODUCT_MENU);
            System.out.println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(Product product:catProducts){
            System.out.println(product.getId() + ". " + product.getTitle() + " - Rs." + product.getPrice());
        }

    }
}
