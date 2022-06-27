package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wdke.stock.utils.BigDecimalUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * 净利润
 *
 * @Author: wdke
 * @Date: 1/28/21 3:53 PM
 * @Version: 1.0
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockInfoEarningVo implements Serializable {

    private String day;

    private Float money;


    private Integer times;

    private Float aveMoney;


    public StockInfoEarningVo(String day) {
        this.day = day;
        this.money = 0f;
        this.times = 0;
    }

    public StockInfoEarningVo(String day, Double money) {
        this.day = day;
        this.money = BigDecimalUtils.formatFloat(money, 2);
        this.times = 0;
    }


    public void addMoney(float money) {

        if (null == this.money) {
            this.money = 0f;
        }

        this.money += money;
    }


    public void addTimes() {

        if (null == this.times) {
            this.times = 0;
        }

        this.times++;
    }

    public Float getAveMoney() {
        if (0 == times) {
            return 0f;
        }
        return BigDecimalUtils.formatFloat(this.money / times, 2);
    }
}
