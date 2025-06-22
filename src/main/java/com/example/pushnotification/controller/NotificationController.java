package com.example.pushnotification.controller;

import com.example.pushnotification.dto.FCMTokenRequest;
import com.example.pushnotification.service.FCMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private FCMService fcmService;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam String token,
                                                   @RequestParam String title,
                                                   @RequestParam String body) {
        String response = fcmService.sendNotification(token, title, body);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/token")
    public void receiveToken(@RequestBody FCMTokenRequest request){
        log.info("token: "+ request.getToken());
    }
}
