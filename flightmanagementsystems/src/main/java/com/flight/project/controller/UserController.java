package com.flight.project.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.flight.project.dto.User;
import com.flight.project.servicelayer.UserServiceImpl;



@RestController
@RequestMapping("/user")
public class UserController {
    private UserServiceImpl userService;
    public UserController(UserServiceImpl userService) {
        super();
        this.userService = userService;
    }
    
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        return new ResponseEntity<User>(userService.createUser(newUser), HttpStatus.CREATED);
        
    }
    @GetMapping
    public List<User>getAllUser(){
    	return userService.getAllUsers();
    }
    @GetMapping("{id}")
    public ResponseEntity<User>getUserById(@PathVariable("id")long userId){
    	return new ResponseEntity<User>(userService.getUserById(userId),
    			HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,
    		@RequestBody User user ){
        return new ResponseEntity<User>
        (userService.updateUser(user,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteUser(@PathVariable("id") long id){
    	userService.deleteUser(id);
    	return new ResponseEntity<String>("user deleted successfully..",HttpStatus.OK);
    }


}