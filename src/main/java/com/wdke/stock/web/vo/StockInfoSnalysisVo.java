package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wdke.stock.storage.entity.StockInfoSnalysis;

/**
 * @Author: wdke
 * @Date: 2020-11-09 19:06
 * @Version: 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockInfoSnalysisVo extends StockInfoSnalysis {
}
