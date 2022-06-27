package com.wdke.stock.storage.entity;

import java.io.Serializable;
import java.util.Date;

public class StockInfoMonth extends StockInfoMonthKey implements Serializable {
    private String stockName;

    private Float open;

    private Float high;

    private Integer hignTime;

    private Float low;

    private Integer lowTime;

    private Float close;

    private Float yestClose;

    private Float differences;

    private Long volume;

    private Integer buyTime;

    private Integer sellTime;

    private Float buyMoney;

    private Float buyMoneyRate;

    private Integer failTime;

    private Integer failEndTime;

    private Float failMoney;

    private Float failMoneyRate;

    private Float netProfit;

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

    public Float getOpen() {
        return open;
    }

    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Integer getHignTime() {
        return hignTime;
    }

    public void setHignTime(Integer hignTime) {
        this.hignTime = hignTime;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Integer getLowTime() {
        return lowTime;
    }

    public void setLowTime(Integer lowTime) {
        this.lowTime = lowTime;
    }

    public Float getClose() {
        return close;
    }

    public void setClose(Float close) {
        this.close = close;
    }

    public Float getYestClose() {
        return yestClose;
    }

    public void setYestClose(Float yestClose) {
        this.yestClose = yestClose;
    }

    public Float getDifferences() {
        return differences;
    }

    public void setDifferences(Float differences) {
        this.differences = differences;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Integer getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Integer buyTime) {
        this.buyTime = buyTime;
    }

    public Integer getSellTime() {
        return sellTime;
    }

    public void setSellTime(Integer sellTime) {
        this.sellTime = sellTime;
    }

    public Float getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(Float buyMoney) {
        this.buyMoney = buyMoney;
    }

    public Float getBuyMoneyRate() {
        return buyMoneyRate;
    }

    public void setBuyMoneyRate(Float buyMoneyRate) {
        this.buyMoneyRate = buyMoneyRate;
    }

    public Integer getFailTime() {
        return failTime;
    }

    public void setFailTime(Integer failTime) {
        this.failTime = failTime;
    }

    public Integer getFailEndTime() {
        return failEndTime;
    }

    public void setFailEndTime(Integer failEndTime) {
        this.failEndTime = failEndTime;
    }

    public Float getFailMoney() {
        return failMoney;
    }

    public void setFailMoney(Float failMoney) {
        this.failMoney = failMoney;
    }

    public Float getFailMoneyRate() {
        return failMoneyRate;
    }

    public void setFailMoneyRate(Float failMoneyRate) {
        this.failMoneyRate = failMoneyRate;
    }

    public Float getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Float netProfit) {
        this.netProfit = netProfit;
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