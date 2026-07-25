package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;


        //4.request time measure
        long startTime=System.currentTimeMillis();

        //3.generate request id(set header in response)
        String requestId=UUID.randomUUID().toString();

        httpServletResponse.setHeader("X-Request-ID" , requestId);

        //1.request log
        System.out.println("Incoming Request : "
                +httpServletRequest.getMethod()+" "
                +httpServletRequest.getRequestURI());

        try{
            chain.doFilter( request,response);
        }
        finally {
            long duration=System.currentTimeMillis()-startTime;

            //2.response status log
            System.out.println("Response status : " +
                    httpServletResponse.getStatus());

            System.out.println("API Response time : " + duration +" millisecond");

        }





      //  System.out.println("Request entering logging filter");
//
//        chain.doFilter(request, response);
//
//        System.out.println("Response exiting logging filter");
    }
}
