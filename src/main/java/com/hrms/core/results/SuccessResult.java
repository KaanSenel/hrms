package com.hrms.core.results;

public class SuccessResult extends Result{

    public SuccessResult() {
        super(true, "Kayıt işlemi başarılı.");
    }
    public SuccessResult(String message){
        super(true,message);
    }
}
