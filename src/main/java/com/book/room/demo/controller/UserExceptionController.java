package com.book.room.demo.controller;

import com.book.room.demo.exception.PasswordException;
import com.book.room.demo.exception.UserExistsException;
import com.book.room.demo.exception.UserNotFoundException;
import com.book.room.demo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages={"com.book.room.demo"})
public class UserExceptionController  {

    @ExceptionHandler(value = { PasswordException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(PasswordException ex)
    {
        return new ErrorResponse(400, ex.getMessage());
    }

    @ExceptionHandler(value = { UserExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(UserExistsException ex)
    {
        return new ErrorResponse(400, ex.getMessage());
    }

    @ExceptionHandler(value = { UserNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse unKnownException(UserNotFoundException ex)
    {

        return new ErrorResponse(404, ex.getMessage());
    }

}
