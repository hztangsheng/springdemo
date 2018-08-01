package com.victory.spring.demo.feign;


import org.springframework.stereotype.Component;

/**
 * 指定异常（断路器）处理类
 */
@Component
public class FeignServiceHomeImpl implements  FeignServiceHome {


    /**
     *   重载接口中请求的方法
     * @param name
     * @return
     */
    @Override
   public  String  feigntoHome( String  name){
       return  "请求失败";
    }
}
