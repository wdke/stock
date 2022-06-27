package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wdke
 * @Date: 2020-11-09 18:44
 * @Version: 1.0
 */
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockInfoVo implements Serializable {
    private String stockCode;

    private Integer stockType;

    private String stockName;
}
