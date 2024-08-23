package com.exampleCrud.exampleDemo01.service.impl;

import com.exampleCrud.exampleDemo01.model.Post;
import com.exampleCrud.exampleDemo01.repository.PostRepository;
import com.exampleCrud.exampleDemo01.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    //save post in database
    @Override
    public Post savePost(Post post){
        return postRepository.save(post);
    }

    //get all post form database
    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    //get post using id
    @Override
    public Post getPostbyId(long id) {
        Optional<Post> post =  postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update post
    @Override
    public Post updatePost(Post post, long id) {
        Post existingPost = postRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingPost.setBody(post.getBody());
        existingPost.setTitle(post.getTitle());
        existingPost.setStatus(post.getStatus());
        existingPost.setReviews(post.getReviews());
        existingPost.setCreated_at(post.getCreated_at());
        existingPost.setUser_id(post.getUser_id());

        // save
        postRepository.save(existingPost);
        return existingPost;
    }

    //delete post
    @Override
    public void deletePost(long id) {
        //check
        postRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        postRepository.deleteById(id);
    }
}
