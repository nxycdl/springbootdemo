package com.ycfd.entry;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by nxycd on 2018/12/16.
 */
@Data
public class PayDetail {

    private Long id;
    private BigDecimal amount;
    private Date orderdate;
    private String orderInfo;

}
