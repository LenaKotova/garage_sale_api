package com.portfolio.garagesale.exceptions;

public class UserNotFoundsException extends Exception{
    public UserNotFoundsException(Long id) {
        super("User with id=" + id + " was not found");
    }
}
