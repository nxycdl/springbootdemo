package com.ycfd.api.service;

import com.ycfd.entry.PayDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nxycd on 2018/12/16.
 */
@RestController
public class PayServiceImp implements PayService{

    @GetMapping("/getPayDetail")
    @Override
    public List<PayDetail> getPayDetail(@RequestParam("id") String id) {
        System.out.println(new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<PayDetail> list = new ArrayList<>();
        PayDetail pay = new PayDetail();
        pay.setAmount(new BigDecimal(100));
        pay.setId(100L);
        pay.setOrderdate(new Date());
        pay.setOrderInfo("This is first Order");
        list.add(pay);

        PayDetail pay1 = new PayDetail();
        pay1.setAmount(new BigDecimal(1000));
        pay1.setId(200L);
        pay1.setOrderdate(new Date());
        pay1.setOrderInfo("This is second Order");
        list.add(pay1);
        return list;
    }
    @PostMapping("/pay")
    @Override
    public int savePay(@RequestBody PayDetail payDetail) {
        System.out.println("insert");
        return 0;
    }
}
