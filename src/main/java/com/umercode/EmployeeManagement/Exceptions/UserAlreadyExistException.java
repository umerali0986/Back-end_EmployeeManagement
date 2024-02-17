package com.umercode.EmployeeManagement.Exceptions;

public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(String message){
        super("User with " + message + " already exist");
    }
}
