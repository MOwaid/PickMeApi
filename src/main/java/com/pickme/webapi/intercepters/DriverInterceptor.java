package com.pickme.webapi.intercepters;

import com.pickme.webapi.common.DriverTokenValidator;
import com.pickme.webapi.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DriverInterceptor implements HandlerInterceptor {
    @Autowired
    private DriverTokenValidator driverTokenValidator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        boolean result = true;//driverTokenValidator.validate(request);

        if(!result)
            response.sendError(HttpStatus.UNAUTHORIZED.value(),"Invalid Token");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
