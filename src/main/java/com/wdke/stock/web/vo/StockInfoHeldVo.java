package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回值
 *
 * @Author: wdke
 * @Date: 1/28/21 10:14 AM
 * @Version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockInfoHeldVo implements Serializable {
    private Integer id;

    private String stockCode;

    private Integer stockType;

    private String stockName;

    private Float money;

    private Integer number;

    private Float buyPrice;

    private Integer buyTradingId;

    private Float sellingPrice;

    private Integer sellingTradingId;

    private Integer types;

    private Integer isend;

    private Long userId;

    private Date createDate;

    private Date updateDate;


    public Long getCreateDate() {
        return this.createDate.getTime();
    }

    public Long getUpdateDate() {
        return this.updateDate.getTime();
    }


    public String getKey() {
        return stockCode + stockType;
    }
}
