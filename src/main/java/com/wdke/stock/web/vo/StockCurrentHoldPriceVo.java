package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wdke.stock.storage.entity.StockHoldings;
import com.wdke.stock.utils.BigDecimalUtils;
import lombok.Data;

/**
 * 持有股票信息
 *
 * @Author: wdke
 * @Date: 2020-10-27 11:08
 * @Version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockCurrentHoldPriceVo extends StockHoldings {


    private String currentPricePercentage;

    private String holdPricePercentage;

    private Float currentTimePrice = 0F;

    private Float historyLowPrice = 0F;

    private Float historyHightPrice = 0F;

    private Float yesterdayClosingPrice = 0F;

    private Float tradingMoney = 0F;


    private StockSeccodsPriceVo stock;


    public Float getCurrentPrice() {
        if (getHoldNumber() == 0) {
            return 0F;
        }
        return BigDecimalUtils.formatFloat((getBuyMoney() - getSellMoney()) / getHoldNumber(), 3);
    }


    //今日价格金额差异
    public Float getTodayEarnings() {
        if (getYesterdayClosingPrice() == 0 || getHoldNumber() == 0 || getCurrentTimePrice() == 0) {
            return 0F;
        }
        int holdNum = getHoldNumber();
        float yesPrice = getYesterdayClosingPrice();
        float currentPrice = getCurrentTimePrice();
        Float result = BigDecimalUtils.formatFloat(holdNum * (currentPrice - yesPrice), 3);

        return result;
    }


    //今日价格差异百分比
    public Float getTodayEarningsPercentage() {
        if (getYesterdayClosingPrice() == 0 || getHoldNumber() == 0 || getCurrentTimePrice() == 0) {
            return 0F;
        }
        float yesPrice = getYesterdayClosingPrice();
        float currentPrice = getCurrentTimePrice();

        Float result = BigDecimalUtils.formatFloat(100 * (currentPrice - yesPrice) / yesPrice, 2);

        return result;
    }

    //持仓累计盈利
    public Float getHoldingEarnings() {
        if (null == getBuyMoney() || null == getSellMoney()) {
            return 0F;
        }
        if (getHoldNumber() == null || getHoldNumber() == 0) {
            return BigDecimalUtils.formatFloat(getBuyMoney() - getSellMoney(), 3);
        }
        Integer holdNumber = getHoldNumber();
        float currentPrice = getCurrentTimePrice();
        float result = holdNumber * currentPrice - getBuyMoney() + getSellMoney();

        return BigDecimalUtils.formatFloat(result, 3);
    }

    public Float getHoldingEarningsPercentage() {
        if (getHoldingEarnings() == 0 || getBuyMoney() == 0) {
            return 0F;
        }
        Float result = BigDecimalUtils.formatFloat(100 * getHoldingEarnings() / getBuyMoney(), 2);
        return result;
    }
}
