package com.exampleCrud.exampleDemo01.service.impl;

import com.exampleCrud.exampleDemo01.model.User;
import com.exampleCrud.exampleDemo01.repository.UserRepository;
import com.exampleCrud.exampleDemo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //save user in database
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    //get all users form database
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get user using id
    @Override
    public User getUserById(long id) {
        Optional<User> user =  userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update user
    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingUser.setPassword(user.getPassword());
        existingUser.setLocation(user.getLocation());
        existingUser.setUsername(user.getUsername());
        // save
        userRepository.save(existingUser);
        return existingUser;
    }

    //delete employee
    @Override
    public void deleteUser(long id) {
        //check
        userRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        userRepository.deleteById(id);
    }
}
