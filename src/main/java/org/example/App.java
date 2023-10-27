package org.example;

import org.example.controller.AppController;
import org.example.util.AppException;
import org.example.util.LoadUtils;

public class App {
    public static void main(String[] args) throws AppException {
        AppController appController = new AppController();
        appController.init();
    }
}