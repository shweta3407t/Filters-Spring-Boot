package com.example.filterDemo;

import com.example.filterDemo.filter.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilter(){
        FilterRegistrationBean<DummyFilter> registrationBean =new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());

        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/api/*  , /admin/*");
//        registrationBean.setName("shweta");


        return  registrationBean;
    }
}
