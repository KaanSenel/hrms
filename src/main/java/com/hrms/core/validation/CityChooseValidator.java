package com.hrms.core.validation;

public class CityChooseValidator {

    public static boolean cityCheck(int id){
        if(String.valueOf(id)==null){
            return false;
        }
        return id>=1 && id<82;
    }
}
