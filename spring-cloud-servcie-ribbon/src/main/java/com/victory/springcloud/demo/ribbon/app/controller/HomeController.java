package com.victory.springcloud.demo.ribbon.app.controller;

import com.victory.springcloud.demo.ribbon.app.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 负载均衡
 */
@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("/")
    public  String  toHome(){
        return  homeService.toHome("张三");
    }

}
