package com.book.room.demo.controller;

import com.book.room.demo.exception.PasswordException;
import com.book.room.demo.model.User;
import com.book.room.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "Room Booking Management System", description = "Operations on User")
public class UserController {

    //Inject the Service Class
    @Autowired
    private UserService userService;

    //POST endpoint to add new Customer to the System
    @ApiOperation(value = "Add new Customer to system")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Successfully created a new User"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Error in Service")
    })
    @PostMapping("/customer")
    public ResponseEntity addUser(@RequestBody User user) {
            if(user.getPassword().length()>10)
                throw new PasswordException("Password should not exceed 10 characters");
            userService.addUser(user);
            return new ResponseEntity(HttpStatus.CREATED);
    }

    //GET endpoint to retrieve Customer from system using ID
    @ApiOperation(value = "Retrieve Customer from system")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Successfully retrieved new User"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Error in Service")
    })
    @GetMapping("/customer/{id}")
    public ResponseEntity getUser(@PathVariable String id){
            User user = userService.getUser(Long.parseLong(id));
            return ResponseEntity.ok(user);
    }
}
