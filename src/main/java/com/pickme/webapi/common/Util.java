package com.pickme.webapi.common;

import java.util.Date;
import java.util.Random;

public class Util {

	public static String generateToken() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 32;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
	  return generatedString;
	}
	
	public static Date generateTokenExpiry() {
		long current = new Date().getTime();
		long staticAdd = 1000  * 60 * 60 * 2;
		return new Date(current + staticAdd);
	}
    public static Date generateTokenExpiry(int time) {
        long current = new Date().getTime();
        long extraAdded = 1000  * time * 60;
        return new Date(current + extraAdded);
    }

}
