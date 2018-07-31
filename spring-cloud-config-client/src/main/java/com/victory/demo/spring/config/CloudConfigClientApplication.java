package com.victory.demo.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tangsheng
 * @Date: 2018/7/12 15:01
 * @Description:
 */
@SpringBootApplication
@RestController
public class CloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClientApplication.class,args);
    }

    /**
     * 通过远程配置文件服务器获取phone的值
     */
    @Value("${phone}")String phone;

    @RequestMapping("/get")
    public  String getPhone(){
        return "从  config-server 中获取的phone值为："+phone;

    }


}
