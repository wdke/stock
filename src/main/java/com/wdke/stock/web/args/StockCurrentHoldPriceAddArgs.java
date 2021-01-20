package com.wdke.stock.web.args;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: wdke
 * @Date: 2020-10-23 16:22
 * @Version: 1.0
 */
@Data
public class StockCurrentHoldPriceAddArgs {

    @NotBlank(message = "不能为空")
    private String stockCode;

    private String stockName;

    @NotNull(message = "不能为空")
    private Float currentPrice;

    private Float initialPurchasePrice;

    private Float recentPurchasePrice;

    @NotNull(message = "不能为空")
    private Integer holdNumber;
}
