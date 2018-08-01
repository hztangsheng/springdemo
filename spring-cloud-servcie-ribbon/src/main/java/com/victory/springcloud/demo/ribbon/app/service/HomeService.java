package com.victory.springcloud.demo.ribbon.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeService {

    @Autowired
    private RestTemplate restTemplate;


    public String  toHome(String  name){
       return  restTemplate.getForObject("http://APPSERVICE/home?name="+name,String.class);
    }
}
