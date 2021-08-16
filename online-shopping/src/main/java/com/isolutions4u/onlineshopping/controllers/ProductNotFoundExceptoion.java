package com.isolutions4u.onlineshopping.controllers;

import java.io.Serializable;

public class ProductNotFoundExceptoion extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public ProductNotFoundExceptoion(String message) {
        this.message = System.currentTimeMillis() + " : " + message;
    }

    public ProductNotFoundExceptoion() {
        this("Product Not Available!");
    }

    public String getMessage() {
        return message;
    }

}
