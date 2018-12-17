package com.ycfd.api.service;



import com.ycfd.api.entry.Order;
import com.ycfd.api.entry.User;
import com.ycfd.entry.PayDetail;
import feign.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by nxycd on 2018/12/10.
 */
public interface OrderService{
    @RequestMapping("/getOrder")
    List<Order> getOrder(@RequestParam("username")String username);
    @RequestMapping("/orderToUser")
    String orderToUser(@RequestParam("userId")String userId);

    @RequestMapping("/orderToUserInfo")
    User orderToUserInfo(@RequestParam("userId") String userId);

    @RequestMapping("/orderToTransNxsiwk")
    String orderToTransNxsiwk();

    @RequestMapping("/savePayInfo")
    int savePayInfo();

    @PostMapping("/getPayDetailList")
    List<PayDetail>getPayDetailList(@RequestParam("id") String id);

    @GetMapping("/getPayDetailListHystirx")
    public List<PayDetail> getPayDetailListHystirx(@RequestParam("id") String id);


}
