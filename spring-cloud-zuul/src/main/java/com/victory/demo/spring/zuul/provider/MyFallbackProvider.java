package com.victory.demo.spring.zuul.provider;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * zuul 中实现 熔断机制（TODO  暂未搞明白）
 */
@Component
public class MyFallbackProvider  implements FallbackProvider {

    /**
     * 指定熔断的服务名称，如果是路由中的所有服务都需要熔断   返回 "*"
     * @return
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 设置进行熔断器后，执行了逻辑
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        System.out.println(route +"======");
         return  new ClientHttpResponse() {
             @Override
             public HttpStatus getStatusCode() throws IOException {
                 return HttpStatus.OK;
             }

             @Override
             public int getRawStatusCode() throws IOException {
                 return HttpStatus.OK.value();
             }

             @Override
             public String getStatusText() throws IOException {
                 return "OK";
             }

             @Override
             public void close() {

             }

             @Override
             public InputStream getBody() throws IOException {
                  return   new ByteArrayInputStream("熔断起了作用，数据访问失败".getBytes());
             }

             @Override
             public HttpHeaders getHeaders() {
                 HttpHeaders headers  = new HttpHeaders();
                 headers.setContentType(MediaType.APPLICATION_JSON);
                 return headers;
             }
         };
    }
}
