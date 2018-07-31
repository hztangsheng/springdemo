package com.victory.springcloud.demo.eureka.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaApplication1 {
    private  static Logger log = LoggerFactory.getLogger(EurekaApplication1.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication1.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/home")
    public String home(@RequestParam String name) {
        log.info("xxxx");
        return "home当前应用的端口port= " + port + ",传递的参数是name=:" + name;
    }


    @RequestMapping("/index")
    public String index(@RequestParam String name) {
        return "index= " + port + ",传递的参数是name=:" + name;
    }

}
