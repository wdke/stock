package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 总持仓数据
 *
 * @Author: wdke
 * @Date: 2/3/21 11:22 AM
 * @Version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeldAllMsgVo implements Serializable {

    private Float money;

    private Float cost;

    private Float lost;

    private Float todayLost;
}
