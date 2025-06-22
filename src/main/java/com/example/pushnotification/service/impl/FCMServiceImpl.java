package com.example.pushnotification.service.impl;

import com.example.pushnotification.service.FCMService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FCMServiceImpl implements FCMService {

    public String sendNotification(String targetToken, String title, String body) {
        try {
            Notification notification = Notification.builder()
                    .setTitle(title)
                    .setImage("https://res.cloudinary.com/dnumoo4ox/image/upload/v1750590448/customer/506459183_4108024136132498_4318864235664024564_n_gbwrmn.jpg")
                    .setBody(body)
                    .build();

            Message message = Message.builder()
                    .setToken(targetToken)
                    .setNotification(notification)
                    .build();

            return FirebaseMessaging.getInstance().send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send notification: " + e.getMessage();
        }
    }
}
