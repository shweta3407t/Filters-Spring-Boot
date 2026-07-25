package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(1)
public class AthenticationFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;

            String token=httpServletRequest.getHeader("token");
            String apiKey=httpServletRequest.getHeader("x-api-key");


            //2.authentication
            if(token == null || !token.equals("12345")){
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            //5. error response to client
            if(apiKey == null || !apiKey.equals("shweta12345")){
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                httpServletResponse.setContentType("application/json");
                httpServletResponse.getWriter().write(
                        " {\n" +
                                "     \"message \" : \"invalid or missing api key.\" \n" +
                                " }"
                );
                return;
            }

            chain.doFilter(request,response);
    }
}
