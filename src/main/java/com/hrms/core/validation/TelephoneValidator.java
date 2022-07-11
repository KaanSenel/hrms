package com.hrms.core.validation;

public class TelephoneValidator {

    public static boolean telephoneCheck(String telephoneNumber){
        if(telephoneNumber==null){
            return false;
        }
        if(telephoneNumber.trim().equals("")){
            return false;
        }
        return true;
    }
}
