package com.wdke.stock.common.model;

import lombok.Data;

/**
 * @author wdke
 * @date 2018/10/26
 */
@Data
public class PageParam {
    Integer current=1;

    Integer pageSize=10;

}
