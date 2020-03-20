package com.pickme.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pickme.webapi.document.Booking;

import org.springframework.messaging.Message;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class WebSocketController {

    private static final String SENDING_URL = "/topic/server-broadcaster";
    private static final String RECEIVING_URL = "/server-receiver";
    
    

    private final SimpMessagingTemplate template;
    private AtomicLong counter = new AtomicLong(0);

    private String message = "";

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping(RECEIVING_URL)
    public void onReceivedMessage(String message) {
        System.out.println("New message received : " + message);
    }

    @SubscribeMapping(SENDING_URL)
    public String onSubscribe() {
        return "SUBSCRIBED" + message;
    }

 //   @Scheduled(fixedRate = 1000)
    public void sendMessage(String message) {
        template.convertAndSend(SENDING_URL, message);//buildNextMessage());
    }
    
    @SuppressWarnings("deprecation")
	public String buildMessagebooking(Booking data)
    {
    	 ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
    	    objectNode.put("NotifyTo", "BOOKING");
    	    try {
				objectNode.put("data", mapper.writeValueAsString(data));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   
    	    
    	    
    	    try {
				return mapper.writeValueAsString(objectNode);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return "";
			}
    	    
    }

    private String buildNextMessage() {
        message = "Test" + counter.getAndIncrement();
        System.out.println("Send message " + message);
        return message;
    }
}