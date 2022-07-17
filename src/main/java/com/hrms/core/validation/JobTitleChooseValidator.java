package com.hrms.core.validation;

public class JobTitleChooseValidator {

    public static boolean jobTitleCheck(int id) {
        if(String.valueOf(id)==null){
            return false;
        }
        return id >= 1;
    }
}
