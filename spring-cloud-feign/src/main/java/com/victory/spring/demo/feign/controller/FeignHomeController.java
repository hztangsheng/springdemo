package com.victory.spring.demo.feign.controller;

import com.victory.spring.demo.feign.FeignServiceHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 远程调用
 */
@RestController
public class FeignHomeController {


    @Autowired
    private FeignServiceHome feignServiceHome;


    @RequestMapping("/h")
    public  String   hh(){
        return feignServiceHome.feigntoHome("zhangs");
    }
}
