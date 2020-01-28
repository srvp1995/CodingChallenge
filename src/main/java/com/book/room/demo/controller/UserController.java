package com.book.room.demo.controller;

import com.book.room.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "Room Booking Management System", description = "Operations on User")
public class UserController {

    @ApiOperation(value = "Add new Customer to system")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Successfully created a new User"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping("/customer")
    public ResponseEntity addUser(@RequestBody User user){

        System.out.print("AAAAAAAAAAAA");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve Customer from system")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Successfully retrieved new User"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @GetMapping("/customer/{id}")
    public ResponseEntity getUsers(@PathVariable String id){

        return new ResponseEntity(HttpStatus.FOUND);
    }

}
