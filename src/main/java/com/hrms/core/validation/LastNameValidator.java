package com.hrms.core.validation;


public class LastNameValidator {

    public static boolean lastNameCheck(String lastName){
        if(lastName==null){
            return false;
        }
        return true;
    }
}
