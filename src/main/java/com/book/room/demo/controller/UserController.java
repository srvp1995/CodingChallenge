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

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Add new Customer to system")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Successfully created a new User"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Error in Service")
    })
    @PostMapping("/customer")
    public ResponseEntity addUser(@RequestBody User user){
        try{
            if(user.getPassword().length()>10)
                throw new PasswordException("Password should not exceed 10 characters");
            userService.addUser(user);
            return new ResponseEntity(HttpStatus.CREATED);
        }
       /* catch(PasswordException  p){
            return ResponseEntity.badRequest().body(p.toString());
        }
        catch (UserExistsException e){
            return ResponseEntity.badRequest().body(e.toString());
        }*/
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in Service");
        }

    }

    @ApiOperation(value = "Retrieve Customer from system")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Successfully retrieved new User"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Error in Service")
    })
    @GetMapping("/customer/{id}")
    public ResponseEntity getUsers(@PathVariable String id){

        try{

            User user = userService.getUser(Long.parseLong(id));
            return ResponseEntity.ok(user);
        }

        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in Service");
        }
    }
}
