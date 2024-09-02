package com.maps.book.service.impl;

import com.maps.book.model.Follows;
import com.maps.book.repository.FollowsRepository;
import com.maps.book.service.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowsServiceImpl implements FollowsService {

    @Autowired
    private FollowsRepository followsRepository;

    //save follows in database
    @Override
    public Follows saveFollows(Follows follows){
        return followsRepository.save(follows);
    }

    //get all follows form database
    @Override
    public List<Follows> getAllFollows() {
        return followsRepository.findAll();
    }

    //get follows using id
    @Override
    public Follows getFollowsById(long id) {
        Optional<Follows> follows =  followsRepository.findById(id);
        if(follows.isPresent()){
            return follows.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update follows
    @Override
    public Follows updateFollows(Follows follows, long id) {
        Follows existingFollows = followsRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingFollows.setFollowing_user_id(follows.getFollowing_user_id());
        existingFollows.setFollowed_user_id(follows.getFollowed_user_id());
        existingFollows.setCreated_at(follows.getCreated_at());
        // save
        followsRepository.save(existingFollows);
        return existingFollows;
    }

    //delete follows
    @Override
    public void deleteFollows(long id) {
        //check
        followsRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        followsRepository.deleteById(id);
    }
}
