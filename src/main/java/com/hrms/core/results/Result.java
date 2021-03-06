package com.hrms.core.results;

import lombok.Getter;

@Getter
public class Result {
    private boolean success;
    private String message;

    public Result(String message){
        this.message=message;
    }

    public Result(boolean success,String message){
        this(message);
        this.success=success;
    }

    public Result(boolean success){
        this.success=success;
    }
}
