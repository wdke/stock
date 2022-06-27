package com.wdke.stock.storage.entity;

import java.io.Serializable;
import java.util.Date;

public class StockInfoSnalysis extends StockInfoSnalysisKey implements Serializable {
    private String stockName;

    private Float diff;

    private Float diff3;

    private Float diff5;

    private Float diff30;

    private Integer lastDate;

    private Float lastOpen;

    private Float lastHigh;

    private Float lastClose;

    private Float lastLow;

    private Long lastVolume;

    private Integer lastOpenIndex;

    private Integer lastHighIndex;

    private Integer lastLowIndex;

    private Integer lastCloseIndex;

    private Float lastCloseWeght;

    private Integer lastVolumeIndex;

    private Integer baseNumber;

    private Float averagePrice;

    private Float highPrice;

    private Integer highIndex;

    private Integer highDay;

    private Float lowPrice;

    private Integer lowIndex;

    private Integer lowDay;

    private Integer continueDays;

    private Integer risingDays;

    private Integer fallDays;

    private Integer risingDaysNear;

    private Integer fallDaysNear;

    private Float highPriceNear;

    private Integer highIndexNear;

    private Integer highDayNear;

    private Float lowPriceNear;

    private Integer lowIndexNear;

    private Integer lowDayNear;

    private Integer buyStart;

    private Integer buyEnd;

    private Integer sellStart;

    private Integer sellEnd;

    private Integer isend;

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

    public Float getDiff3() {
        return diff3;
    }

    public void setDiff3(Float diff3) {
        this.diff3 = diff3;
    }

    public Float getDiff5() {
        return diff5;
    }

    public void setDiff5(Float diff5) {
        this.diff5 = diff5;
    }

    public Float getDiff30() {
        return diff30;
    }

    public void setDiff30(Float diff30) {
        this.diff30 = diff30;
    }

    public Integer getLastDate() {
        return lastDate;
    }

    public void setLastDate(Integer lastDate) {
        this.lastDate = lastDate;
    }

    public Float getLastOpen() {
        return lastOpen;
    }

    public void setLastOpen(Float lastOpen) {
        this.lastOpen = lastOpen;
    }

    public Float getLastHigh() {
        return lastHigh;
    }

    public void setLastHigh(Float lastHigh) {
        this.lastHigh = lastHigh;
    }

    public Float getLastClose() {
        return lastClose;
    }

    public void setLastClose(Float lastClose) {
        this.lastClose = lastClose;
    }

    public Float getLastLow() {
        return lastLow;
    }

    public void setLastLow(Float lastLow) {
        this.lastLow = lastLow;
    }

    public Long getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(Long lastVolume) {
        this.lastVolume = lastVolume;
    }

    public Integer getLastOpenIndex() {
        return lastOpenIndex;
    }

    public void setLastOpenIndex(Integer lastOpenIndex) {
        this.lastOpenIndex = lastOpenIndex;
    }

    public Integer getLastHighIndex() {
        return lastHighIndex;
    }

    public void setLastHighIndex(Integer lastHighIndex) {
        this.lastHighIndex = lastHighIndex;
    }

    public Integer getLastLowIndex() {
        return lastLowIndex;
    }

    public void setLastLowIndex(Integer lastLowIndex) {
        this.lastLowIndex = lastLowIndex;
    }

    public Integer getLastCloseIndex() {
        return lastCloseIndex;
    }

    public void setLastCloseIndex(Integer lastCloseIndex) {
        this.lastCloseIndex = lastCloseIndex;
    }

    public Float getLastCloseWeght() {
        return lastCloseWeght;
    }

    public void setLastCloseWeght(Float lastCloseWeght) {
        this.lastCloseWeght = lastCloseWeght;
    }

    public Integer getLastVolumeIndex() {
        return lastVolumeIndex;
    }

    public void setLastVolumeIndex(Integer lastVolumeIndex) {
        this.lastVolumeIndex = lastVolumeIndex;
    }

    public Integer getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(Integer baseNumber) {
        this.baseNumber = baseNumber;
    }

    public Float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Float highPrice) {
        this.highPrice = highPrice;
    }

    public Integer getHighIndex() {
        return highIndex;
    }

    public void setHighIndex(Integer highIndex) {
        this.highIndex = highIndex;
    }

    public Integer getHighDay() {
        return highDay;
    }

    public void setHighDay(Integer highDay) {
        this.highDay = highDay;
    }

    public Float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Float lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Integer getLowIndex() {
        return lowIndex;
    }

    public void setLowIndex(Integer lowIndex) {
        this.lowIndex = lowIndex;
    }

    public Integer getLowDay() {
        return lowDay;
    }

    public void setLowDay(Integer lowDay) {
        this.lowDay = lowDay;
    }

    public Integer getContinueDays() {
        return continueDays;
    }

    public void setContinueDays(Integer continueDays) {
        this.continueDays = continueDays;
    }

    public Integer getRisingDays() {
        return risingDays;
    }

    public void setRisingDays(Integer risingDays) {
        this.risingDays = risingDays;
    }

    public Integer getFallDays() {
        return fallDays;
    }

    public void setFallDays(Integer fallDays) {
        this.fallDays = fallDays;
    }

    public Integer getRisingDaysNear() {
        return risingDaysNear;
    }

    public void setRisingDaysNear(Integer risingDaysNear) {
        this.risingDaysNear = risingDaysNear;
    }

    public Integer getFallDaysNear() {
        return fallDaysNear;
    }

    public void setFallDaysNear(Integer fallDaysNear) {
        this.fallDaysNear = fallDaysNear;
    }

    public Float getHighPriceNear() {
        return highPriceNear;
    }

    public void setHighPriceNear(Float highPriceNear) {
        this.highPriceNear = highPriceNear;
    }

    public Integer getHighIndexNear() {
        return highIndexNear;
    }

    public void setHighIndexNear(Integer highIndexNear) {
        this.highIndexNear = highIndexNear;
    }

    public Integer getHighDayNear() {
        return highDayNear;
    }

    public void setHighDayNear(Integer highDayNear) {
        this.highDayNear = highDayNear;
    }

    public Float getLowPriceNear() {
        return lowPriceNear;
    }

    public void setLowPriceNear(Float lowPriceNear) {
        this.lowPriceNear = lowPriceNear;
    }

    public Integer getLowIndexNear() {
        return lowIndexNear;
    }

    public void setLowIndexNear(Integer lowIndexNear) {
        this.lowIndexNear = lowIndexNear;
    }

    public Integer getLowDayNear() {
        return lowDayNear;
    }

    public void setLowDayNear(Integer lowDayNear) {
        this.lowDayNear = lowDayNear;
    }

    public Integer getBuyStart() {
        return buyStart;
    }

    public void setBuyStart(Integer buyStart) {
        this.buyStart = buyStart;
    }

    public Integer getBuyEnd() {
        return buyEnd;
    }

    public void setBuyEnd(Integer buyEnd) {
        this.buyEnd = buyEnd;
    }

    public Integer getSellStart() {
        return sellStart;
    }

    public void setSellStart(Integer sellStart) {
        this.sellStart = sellStart;
    }

    public Integer getSellEnd() {
        return sellEnd;
    }

    public void setSellEnd(Integer sellEnd) {
        this.sellEnd = sellEnd;
    }

    public Integer getIsend() {
        return isend;
    }

    public void setIsend(Integer isend) {
        this.isend = isend;
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