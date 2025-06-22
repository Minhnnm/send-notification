package com.example.pushnotification.service;

public interface FCMService {
    public String sendNotification(String targetToken, String title, String body);
}
