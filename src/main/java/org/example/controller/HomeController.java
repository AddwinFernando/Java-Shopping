package org.example.controller;

import org.example.util.AppException;
import org.example.util.AppInput;
import org.example.util.StringUtil;
import org.example.view.HomePage;

public class HomeController {
    private final HomePage homePage;
    private final CategoryController categoryController;


    public HomeController() {
        this.homePage = new HomePage();
        this.categoryController = new CategoryController(this);
    }

    public void printMenu() {
        homePage.printMenu();
        try {
            int choice = AppInput.enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 1) {
                categoryController.printMenu();
            } else if (choice == 2) {

            } else if (choice == 3) {
                System.out.println(choice);
            } else if (choice == 4) {
                System.out.println(choice);
            } else if (choice == 5) {
                System.out.println(choice);
            } else {
                invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
            }

        } catch (AppException e) {
            invalidChoice(e);
        }
    }

    private void invalidChoice(AppException appException) {
        System.out.println(appException.getMessage());
        printMenu();
    }
}
