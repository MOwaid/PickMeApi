package com.pickme.webapi;

import java.util.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.webapi.model.Location;
import com.pusher.rest.Pusher;

@RestController
public class PusherTestController {
	@GetMapping("/location")
    public Location location(@RequestParam String vehicle, @RequestParam String lat, @RequestParam String lng) {      
		Location location = new Location();
		location.setVehicleId(vehicle);
		location.setLat(lat);
		location.setLng(lng);
		Pusher pusher = new Pusher("646971", "8680e38b3404c314104d", "4e8a724d316eb22c751f");
		pusher.setCluster("ap1");
		pusher.setEncrypted(true);

		pusher.trigger("vehicle", "location-position", Collections.singletonMap("message", location));
		return location;
    }
}
