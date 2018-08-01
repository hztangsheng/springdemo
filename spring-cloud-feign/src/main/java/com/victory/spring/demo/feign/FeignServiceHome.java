package com.victory.spring.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义远程调用的接口
 */


@FeignClient(value = "appservice",fallback= FeignServiceHomeImpl.class)//指定调用的应用名称appservice,指定出现断路的时候，指定对应的处理接口实现类FeignServiceHomeImpl
public interface FeignServiceHome {



    @RequestMapping( value="/home") //指定调用的地址
     String  feigntoHome(@RequestParam(value="name") String  name);
}
