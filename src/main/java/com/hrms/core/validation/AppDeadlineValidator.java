package com.hrms.core.validation;

import java.time.LocalDate;

public class AppDeadlineValidator {

    public static boolean appDeadlineCheck(LocalDate appDeadLine){
        return appDeadLine!=null;
    }
}
