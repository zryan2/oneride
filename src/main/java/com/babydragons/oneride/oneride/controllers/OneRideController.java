package com.babydragons.oneride.oneride.controllers;

import com.babydragons.database.dao.UserRepository;
import com.babydragons.database.entities.UserEntity;
import com.babydragons.oneride.oneride.models.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/oneride")
public class OneRideController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String test(){
        return "test";
    }

    @GetMapping("/users")
    public List<UserResponse> getResources(){
        Iterable<UserEntity> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();
        for(UserEntity user : users){
            responses.add(new UserResponse(user.getId(), user.getUsername()));
        }
        return responses;
    }



    @PostMapping("/users")
    public void saveData(){
        userRepository.save(new UserEntity(1L, "test"));
        userRepository.save(new UserEntity(2L, "test"));

    }

}
