package com.ycfd.api.entry;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by nxycd on 2018/12/10.
 */
@Data
public class Order {
    private int id;
    private String name;
    private BigDecimal amout;
}
