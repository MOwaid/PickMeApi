package com.pickme.webapi.services;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
@Service
public class AndroidPushNotificationsService {
 
  private static final String FIREBASE_SERVER_KEY = "AAAAM6j0s0I:APA91bEL_nsRSyMxGtnxDvSsye6mia417-otwSSJml8OFyHmgg8MHzNUnibEchnAeM5XXD0y4GdnciP8wDTxph-EWm3dRkCm_ckYHHwmon2-7eb0wCFSCI-NBlPXQjAWtRumT8dkadLc";
  private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
  
  @Async
  public CompletableFuture<String> send(HttpEntity<String> entity) {
 
    RestTemplate restTemplate = new RestTemplate();
 
    /**
    https://fcm.googleapis.com/fcm/send
    Content-Type:application/json
    Authorization:key=FIREBASE_SERVER_KEY*/
 
    ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
    restTemplate.setInterceptors(interceptors);
 
    String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
 
    return CompletableFuture.completedFuture(firebaseResponse);
  }
}
