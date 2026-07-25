package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;


//@Component
public class ResponseBodyFilter implements Filter {//sending httpsServletResponse wrap  --> dispatcher servet  ( instead of httpsServletResponse)

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        ContentCachingResponseWrapper wrappedResponse=new ContentCachingResponseWrapper(httpServletResponse);


        chain.doFilter(httpServletRequest ,wrappedResponse);

        byte[] originalBodyByte=wrappedResponse.getContentAsByteArray();

        String originalBodyString=new String(originalBodyByte);

        String modifiedBody= """
                {
                
                "originalResponse " :%s,
                "appName" : "Student management Application"
                }
                
                
                """.formatted(originalBodyString);

        wrappedResponse.resetBuffer();

        wrappedResponse.getWriter().write(modifiedBody);



        wrappedResponse.copyBodyToResponse();




    }
}
