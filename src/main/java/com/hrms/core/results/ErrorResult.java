package com.hrms.core.results;

public class ErrorResult extends Result{

    public ErrorResult(String message) {
        super(false, message);
    }
}
