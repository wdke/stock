package com.wdke.stock.web.args;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wdke
 * @Date: 1/8/21 2:36 PM
 * @Version: 1.0
 */
@Data
public class StockInfoMonthArgs implements Serializable {


    private String stockCode;

    private Integer stockType;

    private Integer year;

    private Integer month;

}
