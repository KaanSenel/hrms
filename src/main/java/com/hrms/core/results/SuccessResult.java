package com.hrms.core.results;

public class SuccessResult extends Result{

    public SuccessResult() {
        super(true, "İş Arayan Kişi Başarıyla Kaydedildi");
    }
    public SuccessResult(String message){
        super(true,message);
    }
}
