package com.victory.spring.demo.hystrix.controller;

import com.victory.spring.demo.hystrix.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 熔断，指的是，访问的网络不通时，如何处理异常
 */
@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;


    @RequestMapping("/home")
    public String toAppserviceHome() {
        return  homeService.toHome("【home】");

    }

    @RequestMapping("/index")
    public String toAppserviceIndex() {
          return  homeService.toIndex("【index】");

    }
}
