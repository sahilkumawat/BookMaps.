package com.maps.book.controller;
import com.maps.book.model.Post;
import com.maps.book.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post){
        return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<Post> getAllEmployee(){
        return postService.getAllPost();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<Post> getEmployeeById(@PathVariable("id") long postID){
        return new ResponseEntity<Post>(postService.getPostbyId(postID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Post> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Post post){
        return new ResponseEntity<Post>(postService.updatePost(post,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        //delete employee from db
        postService.deletePost(id);
        return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }

}
