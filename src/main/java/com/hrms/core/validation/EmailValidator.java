package com.hrms.core.validation;

public class EmailValidator {

    public static boolean emailCheck(String email){
        if(email==null){
            return false;
        }
        if (email.trim().equals("")){
            return false;
        }
        return true;
    }
}
