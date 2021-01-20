package com.wdke.stock.storage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockInfoDayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public StockInfoDayExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        this.sumCol = null;
        this.offset = null;
        this.limit = null;
    }

    public String getSumCol() {
        return this.sumCol;
    }

    public void setSumCol(String sumCol) {
        this.sumCol = sumCol;
    }

    public StockInfoDayExample sumStockCode() {
        this.sumCol="stock_code";
        return this;
    }

    public StockInfoDayExample sumStockType() {
        this.sumCol="stock_type";
        return this;
    }

    public StockInfoDayExample sumDay() {
        this.sumCol="day";
        return this;
    }

    public StockInfoDayExample sumStockName() {
        this.sumCol="stock_name";
        return this;
    }

    public StockInfoDayExample sumOpen() {
        this.sumCol="open";
        return this;
    }

    public StockInfoDayExample sumHigh() {
        this.sumCol="high";
        return this;
    }

    public StockInfoDayExample sumHignTime() {
        this.sumCol="hign_time";
        return this;
    }

    public StockInfoDayExample sumLow() {
        this.sumCol="low";
        return this;
    }

    public StockInfoDayExample sumLowTime() {
        this.sumCol="low_time";
        return this;
    }

    public StockInfoDayExample sumClose() {
        this.sumCol="close";
        return this;
    }

    public StockInfoDayExample sumYestClose() {
        this.sumCol="yest_close";
        return this;
    }

    public StockInfoDayExample sumDifferences() {
        this.sumCol="differences";
        return this;
    }

    public StockInfoDayExample sumVolume() {
        this.sumCol="volume";
        return this;
    }

    public StockInfoDayExample sumBuyTime() {
        this.sumCol="buy_time";
        return this;
    }

    public StockInfoDayExample sumSellTime() {
        this.sumCol="sell_time";
        return this;
    }

    public StockInfoDayExample sumFailTime() {
        this.sumCol="fail_time";
        return this;
    }

    public StockInfoDayExample sumFailEndTime() {
        this.sumCol="fail_end_time";
        return this;
    }

    public StockInfoDayExample sumCreateDate() {
        this.sumCol="create_date";
        return this;
    }

    public StockInfoDayExample sumUpdateDate() {
        this.sumCol="update_date";
        return this;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public StockInfoDayExample page(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStockCodeIsNull() {
            addCriterion("stock_code is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNotNull() {
            addCriterion("stock_code is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeEqualTo(String value) {
            addCriterion("stock_code =", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotEqualTo(String value) {
            addCriterion("stock_code <>", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThan(String value) {
            addCriterion("stock_code >", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code >=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThan(String value) {
            addCriterion("stock_code <", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThanOrEqualTo(String value) {
            addCriterion("stock_code <=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLike(String value) {
            addCriterion("stock_code like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotLike(String value) {
            addCriterion("stock_code not like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeIn(List<String> values) {
            addCriterion("stock_code in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotIn(List<String> values) {
            addCriterion("stock_code not in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeBetween(String value1, String value2) {
            addCriterion("stock_code between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotBetween(String value1, String value2) {
            addCriterion("stock_code not between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockTypeIsNull() {
            addCriterion("stock_type is null");
            return (Criteria) this;
        }

        public Criteria andStockTypeIsNotNull() {
            addCriterion("stock_type is not null");
            return (Criteria) this;
        }

        public Criteria andStockTypeEqualTo(Integer value) {
            addCriterion("stock_type =", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotEqualTo(Integer value) {
            addCriterion("stock_type <>", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeGreaterThan(Integer value) {
            addCriterion("stock_type >", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_type >=", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeLessThan(Integer value) {
            addCriterion("stock_type <", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeLessThanOrEqualTo(Integer value) {
            addCriterion("stock_type <=", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeIn(List<Integer> values) {
            addCriterion("stock_type in", values, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotIn(List<Integer> values) {
            addCriterion("stock_type not in", values, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeBetween(Integer value1, Integer value2) {
            addCriterion("stock_type between", value1, value2, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_type not between", value1, value2, "stockType");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Integer value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Integer value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Integer value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Integer value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Integer value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Integer> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Integer> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Integer value1, Integer value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Integer value1, Integer value2) {
            addCriterion("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNull() {
            addCriterion("stock_name is null");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNotNull() {
            addCriterion("stock_name is not null");
            return (Criteria) this;
        }

        public Criteria andStockNameEqualTo(String value) {
            addCriterion("stock_name =", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotEqualTo(String value) {
            addCriterion("stock_name <>", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThan(String value) {
            addCriterion("stock_name >", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThanOrEqualTo(String value) {
            addCriterion("stock_name >=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThan(String value) {
            addCriterion("stock_name <", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThanOrEqualTo(String value) {
            addCriterion("stock_name <=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLike(String value) {
            addCriterion("stock_name like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotLike(String value) {
            addCriterion("stock_name not like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameIn(List<String> values) {
            addCriterion("stock_name in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotIn(List<String> values) {
            addCriterion("stock_name not in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameBetween(String value1, String value2) {
            addCriterion("stock_name between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotBetween(String value1, String value2) {
            addCriterion("stock_name not between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andOpenIsNull() {
            addCriterion("open is null");
            return (Criteria) this;
        }

        public Criteria andOpenIsNotNull() {
            addCriterion("open is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEqualTo(Float value) {
            addCriterion("open =", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotEqualTo(Float value) {
            addCriterion("open <>", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThan(Float value) {
            addCriterion("open >", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThanOrEqualTo(Float value) {
            addCriterion("open >=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThan(Float value) {
            addCriterion("open <", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThanOrEqualTo(Float value) {
            addCriterion("open <=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenIn(List<Float> values) {
            addCriterion("open in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotIn(List<Float> values) {
            addCriterion("open not in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenBetween(Float value1, Float value2) {
            addCriterion("open between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotBetween(Float value1, Float value2) {
            addCriterion("open not between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andHighIsNull() {
            addCriterion("high is null");
            return (Criteria) this;
        }

        public Criteria andHighIsNotNull() {
            addCriterion("high is not null");
            return (Criteria) this;
        }

        public Criteria andHighEqualTo(Float value) {
            addCriterion("high =", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotEqualTo(Float value) {
            addCriterion("high <>", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThan(Float value) {
            addCriterion("high >", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThanOrEqualTo(Float value) {
            addCriterion("high >=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThan(Float value) {
            addCriterion("high <", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThanOrEqualTo(Float value) {
            addCriterion("high <=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighIn(List<Float> values) {
            addCriterion("high in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotIn(List<Float> values) {
            addCriterion("high not in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighBetween(Float value1, Float value2) {
            addCriterion("high between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotBetween(Float value1, Float value2) {
            addCriterion("high not between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andHignTimeIsNull() {
            addCriterion("hign_time is null");
            return (Criteria) this;
        }

        public Criteria andHignTimeIsNotNull() {
            addCriterion("hign_time is not null");
            return (Criteria) this;
        }

        public Criteria andHignTimeEqualTo(Integer value) {
            addCriterion("hign_time =", value, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeNotEqualTo(Integer value) {
            addCriterion("hign_time <>", value, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeGreaterThan(Integer value) {
            addCriterion("hign_time >", value, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hign_time >=", value, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeLessThan(Integer value) {
            addCriterion("hign_time <", value, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeLessThanOrEqualTo(Integer value) {
            addCriterion("hign_time <=", value, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeIn(List<Integer> values) {
            addCriterion("hign_time in", values, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeNotIn(List<Integer> values) {
            addCriterion("hign_time not in", values, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeBetween(Integer value1, Integer value2) {
            addCriterion("hign_time between", value1, value2, "hignTime");
            return (Criteria) this;
        }

        public Criteria andHignTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("hign_time not between", value1, value2, "hignTime");
            return (Criteria) this;
        }

        public Criteria andLowIsNull() {
            addCriterion("low is null");
            return (Criteria) this;
        }

        public Criteria andLowIsNotNull() {
            addCriterion("low is not null");
            return (Criteria) this;
        }

        public Criteria andLowEqualTo(Float value) {
            addCriterion("low =", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotEqualTo(Float value) {
            addCriterion("low <>", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThan(Float value) {
            addCriterion("low >", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThanOrEqualTo(Float value) {
            addCriterion("low >=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThan(Float value) {
            addCriterion("low <", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThanOrEqualTo(Float value) {
            addCriterion("low <=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowIn(List<Float> values) {
            addCriterion("low in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotIn(List<Float> values) {
            addCriterion("low not in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowBetween(Float value1, Float value2) {
            addCriterion("low between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotBetween(Float value1, Float value2) {
            addCriterion("low not between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andLowTimeIsNull() {
            addCriterion("low_time is null");
            return (Criteria) this;
        }

        public Criteria andLowTimeIsNotNull() {
            addCriterion("low_time is not null");
            return (Criteria) this;
        }

        public Criteria andLowTimeEqualTo(Integer value) {
            addCriterion("low_time =", value, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeNotEqualTo(Integer value) {
            addCriterion("low_time <>", value, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeGreaterThan(Integer value) {
            addCriterion("low_time >", value, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_time >=", value, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeLessThan(Integer value) {
            addCriterion("low_time <", value, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeLessThanOrEqualTo(Integer value) {
            addCriterion("low_time <=", value, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeIn(List<Integer> values) {
            addCriterion("low_time in", values, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeNotIn(List<Integer> values) {
            addCriterion("low_time not in", values, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeBetween(Integer value1, Integer value2) {
            addCriterion("low_time between", value1, value2, "lowTime");
            return (Criteria) this;
        }

        public Criteria andLowTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("low_time not between", value1, value2, "lowTime");
            return (Criteria) this;
        }

        public Criteria andCloseIsNull() {
            addCriterion("close is null");
            return (Criteria) this;
        }

        public Criteria andCloseIsNotNull() {
            addCriterion("close is not null");
            return (Criteria) this;
        }

        public Criteria andCloseEqualTo(Float value) {
            addCriterion("close =", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotEqualTo(Float value) {
            addCriterion("close <>", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThan(Float value) {
            addCriterion("close >", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThanOrEqualTo(Float value) {
            addCriterion("close >=", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThan(Float value) {
            addCriterion("close <", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThanOrEqualTo(Float value) {
            addCriterion("close <=", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseIn(List<Float> values) {
            addCriterion("close in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotIn(List<Float> values) {
            addCriterion("close not in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseBetween(Float value1, Float value2) {
            addCriterion("close between", value1, value2, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotBetween(Float value1, Float value2) {
            addCriterion("close not between", value1, value2, "close");
            return (Criteria) this;
        }

        public Criteria andYestCloseIsNull() {
            addCriterion("yest_close is null");
            return (Criteria) this;
        }

        public Criteria andYestCloseIsNotNull() {
            addCriterion("yest_close is not null");
            return (Criteria) this;
        }

        public Criteria andYestCloseEqualTo(Float value) {
            addCriterion("yest_close =", value, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseNotEqualTo(Float value) {
            addCriterion("yest_close <>", value, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseGreaterThan(Float value) {
            addCriterion("yest_close >", value, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseGreaterThanOrEqualTo(Float value) {
            addCriterion("yest_close >=", value, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseLessThan(Float value) {
            addCriterion("yest_close <", value, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseLessThanOrEqualTo(Float value) {
            addCriterion("yest_close <=", value, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseIn(List<Float> values) {
            addCriterion("yest_close in", values, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseNotIn(List<Float> values) {
            addCriterion("yest_close not in", values, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseBetween(Float value1, Float value2) {
            addCriterion("yest_close between", value1, value2, "yestClose");
            return (Criteria) this;
        }

        public Criteria andYestCloseNotBetween(Float value1, Float value2) {
            addCriterion("yest_close not between", value1, value2, "yestClose");
            return (Criteria) this;
        }

        public Criteria andDifferencesIsNull() {
            addCriterion("differences is null");
            return (Criteria) this;
        }

        public Criteria andDifferencesIsNotNull() {
            addCriterion("differences is not null");
            return (Criteria) this;
        }

        public Criteria andDifferencesEqualTo(Float value) {
            addCriterion("differences =", value, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesNotEqualTo(Float value) {
            addCriterion("differences <>", value, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesGreaterThan(Float value) {
            addCriterion("differences >", value, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesGreaterThanOrEqualTo(Float value) {
            addCriterion("differences >=", value, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesLessThan(Float value) {
            addCriterion("differences <", value, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesLessThanOrEqualTo(Float value) {
            addCriterion("differences <=", value, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesIn(List<Float> values) {
            addCriterion("differences in", values, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesNotIn(List<Float> values) {
            addCriterion("differences not in", values, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesBetween(Float value1, Float value2) {
            addCriterion("differences between", value1, value2, "differences");
            return (Criteria) this;
        }

        public Criteria andDifferencesNotBetween(Float value1, Float value2) {
            addCriterion("differences not between", value1, value2, "differences");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(Long value) {
            addCriterion("volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(Long value) {
            addCriterion("volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(Long value) {
            addCriterion("volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(Long value) {
            addCriterion("volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(Long value) {
            addCriterion("volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(Long value) {
            addCriterion("volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<Long> values) {
            addCriterion("volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<Long> values) {
            addCriterion("volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(Long value1, Long value2) {
            addCriterion("volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(Long value1, Long value2) {
            addCriterion("volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNull() {
            addCriterion("buy_time is null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNotNull() {
            addCriterion("buy_time is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeEqualTo(Integer value) {
            addCriterion("buy_time =", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotEqualTo(Integer value) {
            addCriterion("buy_time <>", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThan(Integer value) {
            addCriterion("buy_time >", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_time >=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThan(Integer value) {
            addCriterion("buy_time <", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThanOrEqualTo(Integer value) {
            addCriterion("buy_time <=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIn(List<Integer> values) {
            addCriterion("buy_time in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotIn(List<Integer> values) {
            addCriterion("buy_time not in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeBetween(Integer value1, Integer value2) {
            addCriterion("buy_time between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_time not between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeIsNull() {
            addCriterion("sell_time is null");
            return (Criteria) this;
        }

        public Criteria andSellTimeIsNotNull() {
            addCriterion("sell_time is not null");
            return (Criteria) this;
        }

        public Criteria andSellTimeEqualTo(Integer value) {
            addCriterion("sell_time =", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeNotEqualTo(Integer value) {
            addCriterion("sell_time <>", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeGreaterThan(Integer value) {
            addCriterion("sell_time >", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_time >=", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeLessThan(Integer value) {
            addCriterion("sell_time <", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeLessThanOrEqualTo(Integer value) {
            addCriterion("sell_time <=", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeIn(List<Integer> values) {
            addCriterion("sell_time in", values, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeNotIn(List<Integer> values) {
            addCriterion("sell_time not in", values, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeBetween(Integer value1, Integer value2) {
            addCriterion("sell_time between", value1, value2, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_time not between", value1, value2, "sellTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeIsNull() {
            addCriterion("fail_time is null");
            return (Criteria) this;
        }

        public Criteria andFailTimeIsNotNull() {
            addCriterion("fail_time is not null");
            return (Criteria) this;
        }

        public Criteria andFailTimeEqualTo(Integer value) {
            addCriterion("fail_time =", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotEqualTo(Integer value) {
            addCriterion("fail_time <>", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeGreaterThan(Integer value) {
            addCriterion("fail_time >", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fail_time >=", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeLessThan(Integer value) {
            addCriterion("fail_time <", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeLessThanOrEqualTo(Integer value) {
            addCriterion("fail_time <=", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeIn(List<Integer> values) {
            addCriterion("fail_time in", values, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotIn(List<Integer> values) {
            addCriterion("fail_time not in", values, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeBetween(Integer value1, Integer value2) {
            addCriterion("fail_time between", value1, value2, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("fail_time not between", value1, value2, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeIsNull() {
            addCriterion("fail_end_time is null");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeIsNotNull() {
            addCriterion("fail_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeEqualTo(Integer value) {
            addCriterion("fail_end_time =", value, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeNotEqualTo(Integer value) {
            addCriterion("fail_end_time <>", value, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeGreaterThan(Integer value) {
            addCriterion("fail_end_time >", value, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fail_end_time >=", value, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeLessThan(Integer value) {
            addCriterion("fail_end_time <", value, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("fail_end_time <=", value, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeIn(List<Integer> values) {
            addCriterion("fail_end_time in", values, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeNotIn(List<Integer> values) {
            addCriterion("fail_end_time not in", values, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("fail_end_time between", value1, value2, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andFailEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("fail_end_time not between", value1, value2, "failEndTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria addConditionSql(String conditionSql) {
            addCriterion(conditionSql);
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}