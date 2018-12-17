package com.ycfd.api.service;

import com.ycfd.api.entry.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nxycd on 2018/12/10.
 */
public interface UserService {

    @RequestMapping("/getUser")
    User getUser(@RequestParam("username") String username);
    @RequestMapping("/getUserById")
    User getUserById(@RequestParam("userId") String userId);
}
