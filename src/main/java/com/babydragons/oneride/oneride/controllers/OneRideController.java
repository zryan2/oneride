package com.babydragons.oneride.oneride.controllers;

import com.babydragons.oneride.oneride.FirebaseConnection;
import com.babydragons.oneride.oneride.models.UpdateUserRequest;
import com.babydragons.oneride.oneride.models.UserResponse;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

@CrossOrigin
@RestController
@RequestMapping("/oneride")
public class OneRideController {

    @Autowired
    private FirebaseConnection firebaseConnection;

    @GetMapping("/users")
    public List<UserResponse> getUsers(@PathVariable("id") long id, @PathVariable("username") String username) throws Exception{
        UserResponse response = new UserResponse(id, username);
//        firebaseConnection.save(response);

        return firebaseConnection.getUsers();
    }

    @PutMapping("/update_user")
    public void updateUser(@RequestBody UpdateUserRequest request){
        firebaseConnection.updateUser(request);
        System.out.println(request);
    }

    @GetMapping("/assign_rides")
    public void assignRides(){
        firebaseConnection.assignRiders();
    }
//    private void initFirebase() throws Exception{
////        FileInputStream serviceAccount = null;
////        serviceAccount = new FileInputStream("C:\\Users\\zengr\\IdeaProjects\\oneride\\src\\main\\resources/serviceAccountKey.json");
//
//
//    }


    public String getUserIdFromIdToken(String idToken) throws Exception {
        String userId = null;
        try {
            userId = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
        } catch (InterruptedException | ExecutionException e) {
            throw new Exception("User Not Authenticated");
        }
        return userId;
    }
}
