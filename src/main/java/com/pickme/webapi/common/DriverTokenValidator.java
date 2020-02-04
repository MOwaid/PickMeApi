package com.pickme.webapi.common;

import com.pickme.webapi.document.HttpUserSession;
import com.pickme.webapi.repo.mongo.HttpUserSessionRepository;
import com.pickme.webapi.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class DriverTokenValidator {

    @Autowired
    private DriverService driverService;
    @Value("${driverTokenExpirationTimeMint}")
    private String expirationTimeMint;
    @Autowired
    private HttpUserSessionRepository httpUserSessionRepository;


    public boolean validate(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("TOKEN");
        String loginId = httpServletRequest.getHeader("LOGIN_ID");

        if ( (token==null || token.isEmpty()))
            return false;

        HttpUserSession httpUserSession = httpUserSessionRepository.findByToken(token);
        Date currentTime = new Date();

        if(currentTime.before(httpUserSession.getTokenExpiry())){
            Date updatedExpTime = Util.generateTokenExpiry(Integer.parseInt(expirationTimeMint));
            httpUserSession.setTokenExpiry(updatedExpTime);
            httpUserSessionRepository.save(httpUserSession);
            return true;
        }else{
            return false;
        }

    }

}
