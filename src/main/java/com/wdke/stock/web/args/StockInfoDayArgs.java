package com.wdke.stock.web.args;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 每天的参数
 *
 * @Author: wdke
 * @Date: 2/2/21 5:40 PM
 * @Version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockInfoDayArgs implements Serializable {


    private Float differences;

    private Integer buyTime;

    private Integer sellTime;

    private Integer failTime;

    private Integer failEndTime;
}
