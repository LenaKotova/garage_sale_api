package com.portfolio.garagesale.exceptions;

import com.portfolio.garagesale.entities.UserEntity;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException (UserEntity user){
        super("User with login " +user.getLogin()+" already exists");
    }
}
