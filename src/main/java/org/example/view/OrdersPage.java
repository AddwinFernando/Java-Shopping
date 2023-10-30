package org.example.view;

import org.example.models.Category;
import org.example.models.User;
import org.example.util.FileUtil;
import org.example.util.UserUtil;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrdersPage {
    public static void printOrders() {
        try {
            Scanner scanner = new Scanner(FileUtil.getOrdersFile());
            while (scanner.hasNext()) {
                String value = scanner.next().trim();
                if (!value.startsWith("id")) {
                    String[] ordersArray = value.split(",");
                    if (Integer.parseInt(ordersArray[4]) == UserUtil.getLoggedUser().getId()){
                        System.out.println(ordersArray[1]+"  "+ordersArray[2]+"  "+ordersArray[3]);
                    }

                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
