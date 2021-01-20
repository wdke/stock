package com.wdke.stock.storage.entity;

import java.io.Serializable;

public class StockInfoSeccondsKey implements Serializable {
    private String stockCode;

    private Integer stockType;

    private Long secconds;

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

    public Long getSecconds() {
        return secconds;
    }

    public void setSecconds(Long secconds) {
        this.secconds = secconds;
    }
}