package com.wdke.stock.web.args;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * @Author: wdke
 * @Date: 2020-11-09 19:21
 * @Version: 1.0
 */
@Data
@ToString
public class StockInfoSnalysisArgs implements Serializable {


    Integer current=1;

    Integer pageSize=10;


//    @NotNull(message = "cannot be null")
    private Integer lastDate;

//    @NotNull(message = "cannot be null")
    private Float lessClose;

//    @NotNull(message = "cannot be null")
    private Float moreClose;


    private Integer day;

//    @NotNull(message = "cannot be null")
    private Float nowPrice;

    private String stockName;

    private Boolean isHold=true;



    private String orderBy;

    public void setOrderBy(String orderBy){
        if(StringUtils.isNotEmpty(orderBy)){
            this.orderBy=orderBy;
        }
    }
}
