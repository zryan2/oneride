package com.babydragons.oneride.oneride;

import com.babydragons.oneride.oneride.models.UpdateUserRequest;
import com.babydragons.oneride.oneride.models.User;
import com.babydragons.oneride.oneride.models.UserResponse;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import org.h2.engine.Database;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class FirebaseConnection {

    private FirebaseDatabase firebaseDatabase;

    public FirebaseConnection () throws Exception{
        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("/serviceAccountKey.json").getInputStream()))
                .setDatabaseUrl("https://oneride-amex.firebaseio.com")
                .build();


        FirebaseApp.initializeApp(firebaseOptions);
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void updateUser(UpdateUserRequest request){
        DatabaseReference databaseReference = firebaseDatabase.getReference("/");
        DatabaseReference childReference = databaseReference.child(request.getUsername());
        User user = new User();
        user.setBalance(request.getBalance());
        user.setStartTime(request.getStartTime());
        user.setEndTime(request.getEndTime());
        user.setDay(request.getDay());
        user.setRideOrDrive(request.getRideOrDrive());

        childReference.setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                System.out.println("Saved Data");
            }
        });

        System.out.println(childReference.getKey());

    }

    public void save(UserResponse userResponse) throws Exception{
        if (userResponse != null) {
            /* Get database root reference */
            DatabaseReference databaseReference = firebaseDatabase.getReference("/");


            List<UserResponse> list = new ArrayList<>();
            list.add(new UserResponse(1L,"test"));
            list.add(new UserResponse(2L,"test"));
            list.add(new UserResponse(3L,"test"));

            /* Get existing child or will be created new child. */
            DatabaseReference childReference = databaseReference.child("list");

            /**
             * The Firebase Java client uses daemon threads, meaning it will not prevent a process from exiting.
             * So we'll wait(countDownLatch.await()) until firebase saves record. Then decrement `countDownLatch` value
             * using `countDownLatch.countDown()` and application will continues its execution.
             */
            CountDownLatch countDownLatch = new CountDownLatch(1);
            childReference.setValue(list, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    System.out.println("Record saved!");
                    // decrement countDownLatch value and application will be continues its execution.
                    countDownLatch.countDown();
                }
            });
            try {
                //wait for firebase to saves record.
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    public List<UserResponse> getUsers(){
        List<UserResponse> responses = new ArrayList<>();
        DatabaseReference ref = firebaseDatabase.getReference("/");

        return responses;
    }


    public FirebaseDatabase getFirebaseDatabase() {
        return firebaseDatabase;
    }

    public void setFirebaseDatabase(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
    }
}
