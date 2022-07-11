package com.hrms.core.validation;

public class YearOfBirthValidator {

    public static boolean yearOfBirthCheck(int yearOfBirth){
        if (yearOfBirth<1){
            return false;
        }
        return true;
    }
}
