package com.hrms.core.validation;

public class CompanyNameValidator {

    public static boolean companyNameCheck(String companyName){
        if(companyName==null){
            return false;
        }
        if(companyName.trim().equals("")){
            return false;
        }
        return true;
    }
}
