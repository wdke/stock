package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wdke.stock.storage.entity.StockInfoDay;
import lombok.Data;

import java.util.Date;

/**
 * @Author: wdke
 * @Date: 2020-11-14 13:58
 * @Version: 1.0
 */
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockSeccodsPriceVo extends StockInfoDay {

    private Date time;

    private Float buyPrice;

    private Float sellPrice;

    private Long  volume;

    private Float money;


    private Long  buy1;

    private Float buyPrice1;

    private Long  buy2;

    private Float buyPrice2;

    private Long  buy3;

    private Float buyPrice3;

    private Long  buy4;

    private Float buyPrice4;

    private Long  buy5;

    private Float buyPrice5;




    private Long  sell1;

    private Float sellPrice1;


    private Long  sell2;

    private Float sellPrice2;

    private Long  sell3;

    private Float sellPrice3;

    private Long  sell4;

    private Float sellPrice4;

    private Long  sell5;

    private Float sellPrice5;
}
