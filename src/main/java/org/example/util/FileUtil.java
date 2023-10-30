package org.example.util;

import java.io.File;

public class FileUtil {
    private static File credentialsFile;
    private static File catogoriesFile;
    private static  File productsFile;

    private static  File ordersFile;
    private static  File cartFile;

    private static  File tempCartFile;

    public static File getCredentialsFile() {
        if (credentialsFile == null)
            credentialsFile = new File("src/main/java/org/example/assets/credentials.csv");
        return credentialsFile;
    }

    public static File getCategoriesFile() {
        if (catogoriesFile == null)
            catogoriesFile= new File("src/main/java/org/example/assets/category.csv");
        return catogoriesFile;
    }

    public static File getProductFile() {
        if (productsFile == null)
            productsFile= new File("src/main/java/org/example/assets/products.csv");
        return productsFile;
    }

    public static File getOrdersFile() {
        if (ordersFile == null)
            ordersFile= new File("src/main/java/org/example/assets/Orders.csv");
        return ordersFile;
    }

    public static File getCartFile() {
        if (cartFile == null)
            cartFile= new File("src/main/java/org/example/assets/cart.csv");
        return cartFile;
    }

    public static File getTempCartFile() {
        if (tempCartFile == null)
            tempCartFile= new File("src/main/java/org/example/assets/tempCart.csv");
        return tempCartFile;
    }
}
