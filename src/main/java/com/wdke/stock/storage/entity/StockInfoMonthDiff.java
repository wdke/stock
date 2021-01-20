package com.wdke.stock.storage.entity;

import java.io.Serializable;
import java.util.Date;

public class StockInfoMonthDiff extends StockInfoMonthDiffKey implements Serializable {
    private String stockName;

    private Float diff;

    private Float lastMonthDiffOpen;

    private Float lastMonthDiffHigh;

    private Float lastMonthDiffLow;

    private Float lastMonthDiffClose;

    private Float lastMonthDiffBuyMoney;

    private Float lastMonthDiffFailMoney;

    private Float lastMonthDiffNetProfit;

    private Float lastYearDiffOpen;

    private Float lastYearDiffHigh;

    private Float lastYearDiffLow;

    private Float lastYearDiffClose;

    private Float lastYearDiffBuyMoney;

    private Float lastYearDiffFailMoney;

    private Float lastYearDiffNetProfit;

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

    public Float getDiff() {
        return diff;
    }

    public void setDiff(Float diff) {
        this.diff = diff;
    }

    public Float getLastMonthDiffOpen() {
        return lastMonthDiffOpen;
    }

    public void setLastMonthDiffOpen(Float lastMonthDiffOpen) {
        this.lastMonthDiffOpen = lastMonthDiffOpen;
    }

    public Float getLastMonthDiffHigh() {
        return lastMonthDiffHigh;
    }

    public void setLastMonthDiffHigh(Float lastMonthDiffHigh) {
        this.lastMonthDiffHigh = lastMonthDiffHigh;
    }

    public Float getLastMonthDiffLow() {
        return lastMonthDiffLow;
    }

    public void setLastMonthDiffLow(Float lastMonthDiffLow) {
        this.lastMonthDiffLow = lastMonthDiffLow;
    }

    public Float getLastMonthDiffClose() {
        return lastMonthDiffClose;
    }

    public void setLastMonthDiffClose(Float lastMonthDiffClose) {
        this.lastMonthDiffClose = lastMonthDiffClose;
    }

    public Float getLastMonthDiffBuyMoney() {
        return lastMonthDiffBuyMoney;
    }

    public void setLastMonthDiffBuyMoney(Float lastMonthDiffBuyMoney) {
        this.lastMonthDiffBuyMoney = lastMonthDiffBuyMoney;
    }

    public Float getLastMonthDiffFailMoney() {
        return lastMonthDiffFailMoney;
    }

    public void setLastMonthDiffFailMoney(Float lastMonthDiffFailMoney) {
        this.lastMonthDiffFailMoney = lastMonthDiffFailMoney;
    }

    public Float getLastMonthDiffNetProfit() {
        return lastMonthDiffNetProfit;
    }

    public void setLastMonthDiffNetProfit(Float lastMonthDiffNetProfit) {
        this.lastMonthDiffNetProfit = lastMonthDiffNetProfit;
    }

    public Float getLastYearDiffOpen() {
        return lastYearDiffOpen;
    }

    public void setLastYearDiffOpen(Float lastYearDiffOpen) {
        this.lastYearDiffOpen = lastYearDiffOpen;
    }

    public Float getLastYearDiffHigh() {
        return lastYearDiffHigh;
    }

    public void setLastYearDiffHigh(Float lastYearDiffHigh) {
        this.lastYearDiffHigh = lastYearDiffHigh;
    }

    public Float getLastYearDiffLow() {
        return lastYearDiffLow;
    }

    public void setLastYearDiffLow(Float lastYearDiffLow) {
        this.lastYearDiffLow = lastYearDiffLow;
    }

    public Float getLastYearDiffClose() {
        return lastYearDiffClose;
    }

    public void setLastYearDiffClose(Float lastYearDiffClose) {
        this.lastYearDiffClose = lastYearDiffClose;
    }

    public Float getLastYearDiffBuyMoney() {
        return lastYearDiffBuyMoney;
    }

    public void setLastYearDiffBuyMoney(Float lastYearDiffBuyMoney) {
        this.lastYearDiffBuyMoney = lastYearDiffBuyMoney;
    }

    public Float getLastYearDiffFailMoney() {
        return lastYearDiffFailMoney;
    }

    public void setLastYearDiffFailMoney(Float lastYearDiffFailMoney) {
        this.lastYearDiffFailMoney = lastYearDiffFailMoney;
    }

    public Float getLastYearDiffNetProfit() {
        return lastYearDiffNetProfit;
    }

    public void setLastYearDiffNetProfit(Float lastYearDiffNetProfit) {
        this.lastYearDiffNetProfit = lastYearDiffNetProfit;
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