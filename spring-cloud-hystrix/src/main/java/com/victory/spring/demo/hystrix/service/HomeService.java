package com.victory.spring.demo.hystrix.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 将HystrixCommand 命令的回调方法放在常规的function中
 */
@Service
public class HomeService {

    @Autowired
    private RestTemplate restTemplate;



    //设置访问断掉的时候，调用的回调方法
    @HystrixCommand(fallbackMethod = "toHomeError")
    public String  toHome(String name){
        return  restTemplate.getForObject("http://APPSERVICE/home?name="+name,String.class);
    }


    //设置访问断掉的时候，调用的回调方法
    @HystrixCommand(fallbackMethod = "toIndexError")
    public  String toIndex(String  name){
        return  restTemplate.getForObject("http://APPSERVICE/index?name="+name,String.class);
    }


    public  String toIndexError(String  name){
        return "调用appservice的toIndex  方法时，出现异常";

    }


    public  String toHomeError(String  name){
        return "调用appservice的toHome  方法时，出现异常";

    }


}
