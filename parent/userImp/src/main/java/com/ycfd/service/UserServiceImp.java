package com.ycfd.service;

import com.ycfd.api.entry.User;
import com.ycfd.api.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nxycd on 2018/12/10.
 */
@RestController
public class UserServiceImp implements UserService {
    @Value("${server.port}")
    private String port ;
    @RequestMapping("/getUser")
    @Override
    public User getUser(@RequestParam("username") String username) {
        User user = new User();
        user.setAge(19);
        user.setUsername(username);
        user.setUserid(port);
        return user;
    }

    @Override
    public User getUserById(@RequestParam("userId")String userId) {
        System.out.println("XXXXXXXX" + userId);
        User user = new User();
        user.setAge(20);
        user.setUsername(port);
        user.setUserid(userId);
        return user;
    }
}
