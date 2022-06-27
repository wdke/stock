package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 图片类
 *
 * @Author: wdke
 * @Date: 2020-10-23 09:12
 * @Version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockEchartVo implements Serializable {


    private String stockCode;

    private String stockName;

    private String title;

    private List<String> legend;

    private List<String> key;

    private List<String> value;


    private Object keys;

    private Object values;


    private Object data;//List<List<Integer>>

    private String minValue;


    public StockEchartVo() {
    }

    public StockEchartVo(String stockCode, String stockName) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.title=stockName;
    }
}
