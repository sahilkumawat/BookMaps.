package com.exampleCrud.exampleDemo01.controller;
import com.exampleCrud.exampleDemo01.model.Follows;
import com.exampleCrud.exampleDemo01.service.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/follows")
public class FollowsController {

    @Autowired
    private FollowsService followsService;

    @PostMapping
    public ResponseEntity<Follows> saveFollows(@RequestBody Follows follows){
        return new ResponseEntity<Follows>(followsService.saveFollows(follows), HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<Follows> getAllFollows(){
        return followsService.getAllFollows();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/follows/1
    public ResponseEntity<Follows> getFollowsById(@PathVariable("id") long employeeID){
        return new ResponseEntity<Follows>(followsService.getFollowsById(employeeID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Follows> updateFollows(@PathVariable("id") long id,
                                                   @RequestBody Follows follows){
        return new ResponseEntity<Follows>(followsService.updateFollows(follows,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFollows(@PathVariable("id") long id){
        //delete employee from db
        followsService.deleteFollows(id);
        return new ResponseEntity<String>("Follows deleted Successfully.",HttpStatus.OK);
    }

}
