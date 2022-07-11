package com.hrms.core.validation;

public class TitleValidator {

    public static boolean titleCheck(String title){
        if(title==null){
            return false;
        }
        if(title.trim().equals("")){
            return false;
        }
        return true;
    }
}
