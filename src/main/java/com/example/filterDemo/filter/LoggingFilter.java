package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;

//        System.out.println("Request entering logging filter");
//
//        chain.doFilter(request, response);
//
//        System.out.println("Response exiting logging filter");


      //request log
        System.out.println("Incoming Request : "
                +httpServletRequest.getMethod()+" "
                +httpServletRequest.getRequestURI());

        chain.doFilter(httpServletRequest,httpServletResponse);

        //response status log
        System.out.println("Response status : " +
                httpServletResponse.getStatus());


    }
}
