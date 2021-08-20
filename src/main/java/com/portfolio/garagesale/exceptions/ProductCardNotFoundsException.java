package com.portfolio.garagesale.exceptions;

public class ProductCardNotFoundsException extends Exception{
    public ProductCardNotFoundsException(Long id) {
        super("Product card with id=" + id + " was not found");
    }
}
