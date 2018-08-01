package com.victory.demo.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: tangsheng
 * @Date: 2018/7/12 14:02
 * @Description:   Springcould-config 将在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以将配置文件放置在一个统一的服务中，以便其它app能直接读取config-server 服务中的配置，
 *               config-server 能够将配置文件 放置在server的本地，也可以放置在类似git这样的环境中去
 *
 *               获取git（根据配置）中某一个特定的配置文件 例如：http://localhost:8080/config-server-demo.yml
 *                                获取文件中的某一个key值：http://localhost:8080/config/name
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CouldConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouldConfigServerApplication.class,args);
    }
}
