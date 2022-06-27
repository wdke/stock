package com.wdke.stock.storage.entity;

import java.io.Serializable;
import java.util.Date;

public class StockInfoSecconds extends StockInfoSeccondsKey implements Serializable {
    private String stockName;

    private Float yestClose;

    private Float price;

    private Float avePrice;

    private Long volume;

    private Date createDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public Float getYestClose() {
        return yestClose;
    }

    public void setYestClose(Float yestClose) {
        this.yestClose = yestClose;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getAvePrice() {
        return avePrice;
    }

    public void setAvePrice(Float avePrice) {
        this.avePrice = avePrice;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}