package com.ycfd.api.service;

import com.ycfd.entry.PayDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by nxycd on 2018/12/16.
 */
public interface PayService {

    @GetMapping("/getPayDetail")
    public List<PayDetail> getPayDetail(@RequestParam("id") String id);

    @PostMapping("/pay")
    public int savePay(@RequestBody PayDetail payDetail);

}
