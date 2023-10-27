package org.example.view;

import org.example.util.StringUtil;

public class RegisterPage {
    public static void printRegistrationSuccessful() {
        try {
            System.out.println("#---------------------#");
            System.out.println(StringUtil.REGISTRATION_SUCCESSFUL);
            System.out.println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void passwordMissMatch() {
        try {
            System.out.println("#---------------------#");
            System.out.println(StringUtil.PASSWORD_MISMATCH);
            System.out.println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
