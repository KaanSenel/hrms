package com.hrms.core.validation;


public class FirstNameValidator {

    public static boolean firstNameCheck(String firstName){
        if (firstName==null){
            return false;
        }
        return true;
    }
}
