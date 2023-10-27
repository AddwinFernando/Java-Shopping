package org.example.util;

import java.util.InputMismatchException;

public class AppInput {
    public static String enterString(String msg){
        Utils.print(msg);
        return AppScanner.getScanner().nextLine();
    }

    public static int enterInt(String msg) throws AppException {
        Utils.print(msg);
        int input;
        try{
            input = Integer.parseInt(AppScanner.getScanner().nextLine());
        }catch (InputMismatchException e){
            throw new AppException("Invalid Input");
        }
        return input;
    }
}
