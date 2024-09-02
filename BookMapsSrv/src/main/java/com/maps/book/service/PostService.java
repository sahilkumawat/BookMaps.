package com.maps.book.service;
import com.maps.book.model.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);
    List<Post> getAllPost();
    Post getPostbyId(long id);
    Post updatePost(Post post,long id);
    void deletePost(long id);
}
