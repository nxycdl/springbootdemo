package com.ycfd.com.ycfd.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ycfd.api.entry.User;
import com.ycfd.api.service.OrderService;
import com.ycfd.api.entry.Order;
import com.ycfd.com.ycfd.feign.PayServiceFeign;
import com.ycfd.com.ycfd.feign.UserServiceFeign;
import com.ycfd.entry.PayDetail;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nxycd on 2018/12/10.
 */
@RestController
public class OrderServiceImp implements OrderService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private PayServiceFeign payServiceFeign;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "remoteRestTemplate")
    private RestTemplate rest;

    @RequestMapping("/getOrder")
    @Override
    public List<Order> getOrder(@RequestParam("username")String username) {
        Order order = new Order();
        order.setName(username);
        List<Order> list = new ArrayList<>();
        list.add(order);
        return list;
    }

    @RequestMapping("/orderToUser")
    @Override
    public String orderToUser(@RequestParam("userId")String userId) {
        System.out.println(userId);
        User user = userServiceFeign.getUserById(userId);
        return user.getUsername();
    }
    @RequestMapping("/orderToUserInfo")
    @Override
    public User orderToUserInfo(@RequestParam("userId")String userId) {
        System.out.println(userId);
        User user = userServiceFeign.getUserById(userId);
        return user;
    }

    @RequestMapping("/orderToTransNxsiwk")
    @Override
    public String orderToTransNxsiwk() {
        String s1 = "", s2 = "" ;
        //这里为什么不适用Fegin是因为 TransferNXsiwk 是一个springboot 工程，本身不包含在这个项目里面
        //所以无法使用接口方式调用，除非改造TransferNxsiw;
        s1 = rest.getForObject("http://192.168.200.85:8100/",String.class);
        System.out.println("1");
        s2 = rest.getForObject("http://192.168.200.85:8100/action/",String.class);
        System.out.println("2");
        String s3 = restTemplate.getForObject("http://transfernxsiwkClient",String.class);
        System.out.println("3");
        String s4 = restTemplate.getForObject("http://transfernxsiwkClient/action/",String.class);
        System.out.println("4");
        String s= s1 + "\t" + s2  + "@@@@" + s3 + "@@@@@" + s4 ;
        System.out.println(s);
        return s;
    }

    @PostMapping("/savePayInfo")
    @Override
    public int savePayInfo() {
        PayDetail payDetail = new PayDetail();
        payDetail.setId(200L);
        return payServiceFeign.savePay(payDetail);
    }
    // 没有解决服务雪崩;
    @GetMapping("/getPayDetailList")
    @Override
    public List<PayDetail> getPayDetailList(@RequestParam("id") String id) {
        System.out.println("getPayDetailList");
        return payServiceFeign.getPayDetail(id);
    }

    // 解决服务雪崩效应
    // Hystirx 有2种方式配置保护服务 ； 注解和接口方式;
    //fallbackMethod 服务降级使用；
    @HystrixCommand(fallbackMethod = "getPayDetailListHystirxFallBack")
    @GetMapping("/getPayDetailListHystirx")
    @Override
    public List<PayDetail> getPayDetailListHystirx(@RequestParam("id") String id) {
        System.out.println("getPayDetailListHystirx");
        return payServiceFeign.getPayDetail(id);
    }

    public List<PayDetail> getPayDetailListHystirxFallBack(@RequestParam("id") String id) {
        System.out.println("服务降级");
        List<PayDetail> list= new ArrayList<>();
        PayDetail pay = new PayDetail();
        pay.setId(201L);
        pay.setOrderInfo("服务降级了");
        list.add(pay);
        return list;
    }


}
