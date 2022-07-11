package com.hrms.core.validation;


public class IdentityNumberValidator {

    public static boolean identityNumberCheck(String identityNumber){
        if(identityNumber==null){
            return false;
        }
        return identityNumber.length() == 11;
    }
}
