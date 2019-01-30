package com.contest.notification.notificationMedium.android;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class AndroidPushNotificationService {

    @Value("${firebase.server.key}")
    private String firebaseServerKey;
    @Value("${firebase.api.url}")
    private String firebaseApiUrl;

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity)
    {
        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors  = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization","key="+ firebaseServerKey));
        interceptors.add(new HeaderRequestInterceptor("Content-Type","application/json"));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(firebaseApiUrl, entity, String.class);
        return CompletableFuture.completedFuture(firebaseResponse);
    }


}