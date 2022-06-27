package com.wdke.stock.web.args;

import lombok.Data;

import java.io.Serializable;

/**
 * 分析参数
 *
 * @Author: wdke
 * @Date: 2020-10-31 04:13
 * @Version: 1.0
 */
@Data
public class StockDaySnalysisArgs implements Serializable {

    private String day;

    private String stockCode;

    private String stockName;

    private Float averagePrice;

    private Float recordHighPrice;

    private Float recordLowPrice;

    private Float nearRecordHighPrice;

    private Float nearRecordLowPrice;

    private Integer lastDays;

    private Float lastDaysLocation;

    private Float open;

    private Float openLocation;

    private Float high;

    private Float highLocation;

    private Float low;

    private Float lowLocation;

    private Float close;

    private Float closeLocation;

    private Long volume;

    private Float volumeLocation;

    private Integer isend;
}
