package com.wdke.stock.storage.entity;

import java.io.Serializable;

public class StockInfoDayKey implements Serializable {
    private String stockCode;

    private Integer stockType;

    private Integer day;

    private static final long serialVersionUID = 1L;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public Integer getStockType() {
        return stockType;
    }

    public void setStockType(Integer stockType) {
        this.stockType = stockType;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}