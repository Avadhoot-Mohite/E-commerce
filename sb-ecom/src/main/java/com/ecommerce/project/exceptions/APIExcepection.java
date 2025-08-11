package com.ecommerce.project.exceptions;

public class APIExcepection extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public APIExcepection(){

    }
    public APIExcepection(String message){
        super(message);
    }

}
