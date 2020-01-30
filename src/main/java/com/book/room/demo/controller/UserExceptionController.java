package com.book.room.demo.controller;

import com.book.room.demo.exception.PasswordException;
import com.book.room.demo.exception.UserExistsException;
import com.book.room.demo.exception.UserNotFoundException;
import com.book.room.demo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionController  {

    //Exception Handler method when password does not match the required criteria
    @ExceptionHandler(PasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest( PasswordException ex)
    {
        return new ErrorResponse(400, ex.getMessage());
    }

    //Exception Handler method when User already exists in Database
    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest( UserExistsException ex)
    {
        return new ErrorResponse(400, ex.getMessage());
    }

    //Exception Handler method when User is not found in Database
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(UserNotFoundException ex)
    {
        return new ErrorResponse(404, ex.getMessage());
    }

    //Exception Handler method to handle the generic exceptions
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse genericException(Exception ex)
    {
        return new ErrorResponse(500, ex.getMessage());
    }
}
