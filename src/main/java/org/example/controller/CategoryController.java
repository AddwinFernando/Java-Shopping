package org.example.controller;

import org.example.models.Category;
import org.example.util.AppException;
import org.example.util.AppInput;
import org.example.util.LoadUtils;
import org.example.util.StringUtil;
import org.example.view.CategoryPage;

import java.util.ArrayList;

public class CategoryController {
    private final CategoryPage categoryPage;
    private final ProductController productController;

    private final HomeController homeController;

    public CategoryController(HomeController homeController) {

        this.categoryPage = new CategoryPage();
        this.homeController = homeController;
        this.productController = new ProductController(homeController);
    }

    public void printMenu() {
        ArrayList<Category> categories = LoadUtils.getCategories();
        categoryPage.printMenu(categories);

        try{
            int choice = AppInput.enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 99){

            } else {
                int catId = 0;
                for(Category cat:categories){
                    if(cat.getId()==choice){
                        catId = choice;
                        break;
                    }
                }
                if(catId!=0) {
                    productController.showProducts(catId);
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
        printMenu();
    }
}
