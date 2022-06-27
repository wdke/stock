package com.wdke.stock.storage.entity;

import java.io.Serializable;
import java.util.Date;

public class StockTrading implements Serializable {
    private Integer id;

    private String stockCode;

    private Integer stockType;

    private String stockName;

    private Float money;

    private Float commission;

    private Float commissionRate;

    private Float transferFee;

    private Float stampDuty;

    private Integer tradingNumber;

    private Float tradingPrice;

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

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Float getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(Float transferFee) {
        this.transferFee = transferFee;
    }

    public Float getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(Float stampDuty) {
        this.stampDuty = stampDuty;
    }

    public Integer getTradingNumber() {
        return tradingNumber;
    }

    public void setTradingNumber(Integer tradingNumber) {
        this.tradingNumber = tradingNumber;
    }

    public Float getTradingPrice() {
        return tradingPrice;
    }

    public void setTradingPrice(Float tradingPrice) {
        this.tradingPrice = tradingPrice;
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
}