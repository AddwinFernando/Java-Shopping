package org.example.view;

import org.example.models.Category;

import java.util.ArrayList;

public class CategoryPage {
    public void printMenu(ArrayList<Category> categories) {
        for (Category cat:categories){
            System.out.println(cat.getId()+" "+cat.getCategoryName());
        }
    }
}
