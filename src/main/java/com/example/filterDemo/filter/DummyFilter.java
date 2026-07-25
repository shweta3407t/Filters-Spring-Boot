package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class DummyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String uri=httpServletRequest.getRequestURI();
        if(!uri.startsWith("/api/")){
            chain.doFilter(httpServletRequest , httpServletResponse);

        }


        System.out.println("Dummy filter called");

        chain.doFilter(httpServletRequest , httpServletResponse);
    }
}
