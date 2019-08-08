package com.babydragons.oneride.oneride;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@SpringBootApplication
public class OneRideApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneRideApplication.class, args);
//        try {
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("/serviceAccountKey.json").getInputStream()))
//                    .setDatabaseUrl("https://oneride-amex.firebaseio.com")
//                    .build();
//            FirebaseApp.initializeApp(options);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
