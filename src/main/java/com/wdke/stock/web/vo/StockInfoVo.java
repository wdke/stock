package com.wdke.stock.web.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wdke
 * @Date: 2020-11-09 18:44
 * @Version: 1.0
 */
@Data
public class StockInfoVo implements Serializable {
    private String stockCode;

    private Integer stockType;

    private String stockName;
}
