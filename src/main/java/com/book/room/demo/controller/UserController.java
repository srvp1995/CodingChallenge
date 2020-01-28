package com.book.room.demo.controller;

import com.book.room.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/customers")
    public ResponseEntity getUsers(User user){

        return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }

}
