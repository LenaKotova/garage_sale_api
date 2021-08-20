package com.portfolio.garagesale.controllers;

import com.portfolio.garagesale.entities.UserEntity;
import com.portfolio.garagesale.exceptions.UserAlreadyExistsException;
import com.portfolio.garagesale.exceptions.UserNotFoundsException;
import com.portfolio.garagesale.models.User;
import com.portfolio.garagesale.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Api ( description = "CRUD API operations with users", tags = "Users")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "Create user", notes = "Create new user")
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity){
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok("User saved successfully");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Get user", notes = "Get the user")
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getUser(id));
        }
        catch (UserNotFoundsException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Get users", notes = "Get a list of all users")
    @GetMapping("/all")
    public ResponseEntity getAllUsers (){
       return ResponseEntity.ok(userService.getAllUsers());
    }

    @ApiOperation(value = "Change user", notes = "Change user parameters: name", produces = "application/json")
    @PutMapping
    public ResponseEntity changeUserName (@RequestBody User userName,
                                          @RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.changeUserName(userName, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @ApiOperation(value = "Delete user", notes = "Delete the user")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }
}
