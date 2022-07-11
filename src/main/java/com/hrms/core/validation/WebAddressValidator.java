package com.hrms.core.validation;

public class WebAddressValidator {

    public static boolean webAddressCheck(String webAddress){
        if(webAddress==null){
            return false;
        }
        if(webAddress.trim().equals("")){
            return false;
        }
        return true;
    }
}
