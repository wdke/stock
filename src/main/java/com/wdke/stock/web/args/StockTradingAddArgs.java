package com.wdke.stock.web.args;

import com.wdke.stock.common.consts.StockConst;
import com.wdke.stock.utils.BigDecimalUtils;
import com.wdke.stock.web.interceptor.UserContext;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 股票交易新增
 *
 * @Author: wdke
 * @Date: 2020-10-23 14:06
 * @Version: 1.0
 */
@Data
public class StockTradingAddArgs implements Serializable {

    @NotBlank(message = "不能为空")
    private String stockCode;

    @NotNull(message = "不能为空")
    private Integer stockType;


    private String stockName;

    @NotNull(message = "不能为空")
    private Integer tradingNumber;

    @NotNull(message = "不能为空")
    private Float tradingPrice;

    @NotNull(message = "不能为空")
    private Integer types;

    public Float getMoney() {
        return BigDecimalUtils.formatFloat(tradingNumber * tradingPrice, 3);
    }

    public Float getCommission() {
        float result = BigDecimalUtils.formatFloat(getMoney() * UserContext.current().getCommissionRate(), 2);
        return result > 5 ? result : 5;
    }


    public Float getTransferFee() {
        return BigDecimalUtils.formatFloat(getMoney() * StockConst.TRANSFER_FEE_RATE, 2);
    }


    public Float getStampDuty() {
        return BigDecimalUtils.formatFloat(getMoney() * StockConst.STAMP_DUTY_RATE, 2);
    }


    public Float getBuyMoney() {
        return getMoney() + getCommission() + getTransferFee();
    }


    public Float getSelltMoney() {
        return getMoney() - getCommission() - getTransferFee()-getStampDuty();
    }
}
