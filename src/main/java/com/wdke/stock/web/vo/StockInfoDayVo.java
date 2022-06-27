package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wdke.stock.storage.entity.StockInfoDay;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-11-09 18:48
 * @Version: 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class StockInfoDayVo implements Serializable {

    private String stockName;

    private String stockCode;

    private Integer stockType;

    private List<StockInfoDay> stockInfoDays;
}
