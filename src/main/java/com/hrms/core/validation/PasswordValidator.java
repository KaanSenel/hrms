package com.hrms.core.validation;


public class PasswordValidator {


    public static boolean passwordCheck(String password,String passwordAgain){
        if(password==null){
            return false;
        }
        return password.equals(passwordAgain);
    }
}