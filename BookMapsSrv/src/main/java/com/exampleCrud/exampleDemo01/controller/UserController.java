package com.exampleCrud.exampleDemo01.controller;
import com.exampleCrud.exampleDemo01.model.User;
import com.exampleCrud.exampleDemo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    //Get by ID Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<User> getUserbyID(@PathVariable("id") long userID){
        return new ResponseEntity<User>(userService.getUserById(userID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,
                                                   @RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        //delete employee from db
        userService.deleteUser(id);
        return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }

}
