package com.ycfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class AppOrderImp {
    public static void main(String[] args) {
        SpringApplication.run(AppOrderImp.class, args);
    }

    // 注册restTemplate 到Srping Boot 容器中;增加LoadBalance 会自动到注册中心按照application那么查找的
    // 当我们使用了ip+端口的时候这个方法就不适用了。因为在注册中心就没有出现有带ip的application那么的项目;
    // 所以这里使用了下面的方式;
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //@IP方式
    @Bean(name="remoteRestTemplate")
    public RestTemplate remoteRestTemplate() {
        return new RestTemplate();
    }

}
