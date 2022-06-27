package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.commons.lang.time.DateFormatUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 交易办结的记录
 *
 * @Author: wdke
 * @Date: 1/28/21 3:00 PM
 * @Version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockInfoHeldEndVo implements Serializable {

    private Float money;

    private String stockCode;

    private Integer stockType;

    private String stockName;

    private List<StockInfoHeldVo> detail;


    public void addMoney(float addMoney){
        if(money==null){
            money=addMoney;
        }else {

            money+=addMoney;
        }

    }

}
