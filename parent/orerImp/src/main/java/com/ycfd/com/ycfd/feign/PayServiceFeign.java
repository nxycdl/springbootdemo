package com.ycfd.com.ycfd.feign;

import com.ycfd.api.service.PayService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by nxycd on 2018/12/16.
 */
@FeignClient(name = "payimp")
public interface PayServiceFeign extends PayService {
}
