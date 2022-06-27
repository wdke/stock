package com.wdke.stock.storage.entity;

import org.apache.commons.lang.time.DateFormatUtils;

import java.io.Serializable;
import java.util.Date;

public class StockInfoHeld implements Serializable {
    private Integer id;

    private String stockCode;

    private Integer stockType;

    private String stockName;

    private Float money;

    private Integer number;

    private Float buyPrice;

    private Integer buyTradingId;

    private Float sellingPrice;

    private Integer sellingTradingId;

    private Integer types;

    private Integer isend;

    private Long userId;

    private Date createDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getBuyTradingId() {
        return buyTradingId;
    }

    public void setBuyTradingId(Integer buyTradingId) {
        this.buyTradingId = buyTradingId;
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getSellingTradingId() {
        return sellingTradingId;
    }

    public void setSellingTradingId(Integer sellingTradingId) {
        this.sellingTradingId = sellingTradingId;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getIsend() {
        return isend;
    }

    public void setIsend(Integer isend) {
        this.isend = isend;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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


    public String operaterDay() {
        return DateFormatUtils.format(this.getUpdateDate(), "yyyy-MM-dd");
    }


}