package org.example.util;

import org.example.models.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadUtils {
    private static ArrayList<Category> categories = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();

    private static ArrayList<Cart> cart = new ArrayList<>();

    public static void setCart(ArrayList<Cart> cart) {
        LoadUtils.cart = cart;
    }

    public static ArrayList<Cart> getCart() {
        return cart;
    }

    //    private static  ArrayList<Order> Orders = new ArrayList<>();
    public static void load(){
        try {
            Scanner scanner = new Scanner(FileUtil.getCategoriesFile());
            while (scanner.hasNext()) {
                String value = scanner.next().trim();
                if (!value.startsWith("id")) {
                    String[] catArray = value.split(",");
                    categories.add(new Category((Integer.parseInt(catArray[0])),catArray[1]));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner scanner = new Scanner(FileUtil.getProductFile());
            while (scanner.hasNext()) {
                String value = scanner.next().trim();
                if (!value.startsWith("id")) {
                    String[] prodArray = value.split(",");
                    Category cat = new Category(0,"dummy");
                    for(Category category:categories){
                        if (category.getCategoryName().equals(prodArray[3])){
                            cat = category;
                            break;
                        }
                    }
                    products.add(new Product(Integer.parseInt(prodArray[0]),prodArray[1],Integer.parseInt(prodArray[2]),cat));
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner scanner = new Scanner(FileUtil.getCartFile());
            while (scanner.hasNext()) {
                String value = scanner.next().trim();
                if (!value.startsWith("user")) {
                    String[] cartArray = value.split(",");
                    cart.add(new Cart(Integer.parseInt(cartArray[0]),Integer.parseInt(cartArray[1]),cartArray[2],Integer.parseInt(cartArray[3]),Double.parseDouble(cartArray[4])));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void logoutCartLoad(ArrayList<Cart> cart){
        try{
            FileWriter csv = new FileWriter(FileUtil.getCartFile(),false);
            for(Cart cartProd: cart){
                csv.append("\n");
                csv.append(cartProd.getUserid()+","+cartProd.getId()+","+cartProd.getTitle()+","+cartProd.getCount()+","+cartProd.getPrice());
            }
            csv.flush();
            csv.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
}
