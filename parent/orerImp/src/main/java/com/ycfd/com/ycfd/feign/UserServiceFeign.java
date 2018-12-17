package com.ycfd.com.ycfd.feign;

import com.ycfd.api.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by nxycd on 2018/12/10.
 */
@FeignClient(name = "userimp")
public interface UserServiceFeign extends UserService {

}
