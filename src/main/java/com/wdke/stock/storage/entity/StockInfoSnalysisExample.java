package com.wdke.stock.storage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockInfoSnalysisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public StockInfoSnalysisExample() {
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

    public StockInfoSnalysisExample sumStockCode() {
        this.sumCol="stock_code";
        return this;
    }

    public StockInfoSnalysisExample sumStockType() {
        this.sumCol="stock_type";
        return this;
    }

    public StockInfoSnalysisExample sumStockName() {
        this.sumCol="stock_name";
        return this;
    }

    public StockInfoSnalysisExample sumDiff() {
        this.sumCol="diff";
        return this;
    }

    public StockInfoSnalysisExample sumDiff3() {
        this.sumCol="diff3";
        return this;
    }

    public StockInfoSnalysisExample sumDiff5() {
        this.sumCol="diff5";
        return this;
    }

    public StockInfoSnalysisExample sumDiff30() {
        this.sumCol="diff30";
        return this;
    }

    public StockInfoSnalysisExample sumLastDate() {
        this.sumCol="last_date";
        return this;
    }

    public StockInfoSnalysisExample sumLastOpen() {
        this.sumCol="last_open";
        return this;
    }

    public StockInfoSnalysisExample sumLastHigh() {
        this.sumCol="last_high";
        return this;
    }

    public StockInfoSnalysisExample sumLastClose() {
        this.sumCol="last_close";
        return this;
    }

    public StockInfoSnalysisExample sumLastLow() {
        this.sumCol="last_low";
        return this;
    }

    public StockInfoSnalysisExample sumLastVolume() {
        this.sumCol="last_volume";
        return this;
    }

    public StockInfoSnalysisExample sumLastOpenIndex() {
        this.sumCol="last_open_index";
        return this;
    }

    public StockInfoSnalysisExample sumLastHighIndex() {
        this.sumCol="last_high_index";
        return this;
    }

    public StockInfoSnalysisExample sumLastLowIndex() {
        this.sumCol="last_low_index";
        return this;
    }

    public StockInfoSnalysisExample sumLastCloseIndex() {
        this.sumCol="last_close_index";
        return this;
    }

    public StockInfoSnalysisExample sumLastCloseWeght() {
        this.sumCol="last_close_weght";
        return this;
    }

    public StockInfoSnalysisExample sumLastVolumeIndex() {
        this.sumCol="last_volume_index";
        return this;
    }

    public StockInfoSnalysisExample sumBaseNumber() {
        this.sumCol="base_number";
        return this;
    }

    public StockInfoSnalysisExample sumAveragePrice() {
        this.sumCol="average_price";
        return this;
    }

    public StockInfoSnalysisExample sumHighPrice() {
        this.sumCol="high_price";
        return this;
    }

    public StockInfoSnalysisExample sumHighIndex() {
        this.sumCol="high_index";
        return this;
    }

    public StockInfoSnalysisExample sumHighDay() {
        this.sumCol="high_day";
        return this;
    }

    public StockInfoSnalysisExample sumLowPrice() {
        this.sumCol="low_price";
        return this;
    }

    public StockInfoSnalysisExample sumLowIndex() {
        this.sumCol="low_index";
        return this;
    }

    public StockInfoSnalysisExample sumLowDay() {
        this.sumCol="low_day";
        return this;
    }

    public StockInfoSnalysisExample sumContinueDays() {
        this.sumCol="continue_days";
        return this;
    }

    public StockInfoSnalysisExample sumRisingDays() {
        this.sumCol="rising_days";
        return this;
    }

    public StockInfoSnalysisExample sumFallDays() {
        this.sumCol="fall_days";
        return this;
    }

    public StockInfoSnalysisExample sumRisingDaysNear() {
        this.sumCol="rising_days_near";
        return this;
    }

    public StockInfoSnalysisExample sumFallDaysNear() {
        this.sumCol="fall_days_near";
        return this;
    }

    public StockInfoSnalysisExample sumHighPriceNear() {
        this.sumCol="high_price_near";
        return this;
    }

    public StockInfoSnalysisExample sumHighIndexNear() {
        this.sumCol="high_index_near";
        return this;
    }

    public StockInfoSnalysisExample sumHighDayNear() {
        this.sumCol="high_day_near";
        return this;
    }

    public StockInfoSnalysisExample sumLowPriceNear() {
        this.sumCol="low_price_near";
        return this;
    }

    public StockInfoSnalysisExample sumLowIndexNear() {
        this.sumCol="low_index_near";
        return this;
    }

    public StockInfoSnalysisExample sumLowDayNear() {
        this.sumCol="low_day_near";
        return this;
    }

    public StockInfoSnalysisExample sumBuyStart() {
        this.sumCol="buy_start";
        return this;
    }

    public StockInfoSnalysisExample sumBuyEnd() {
        this.sumCol="buy_end";
        return this;
    }

    public StockInfoSnalysisExample sumSellStart() {
        this.sumCol="sell_start";
        return this;
    }

    public StockInfoSnalysisExample sumSellEnd() {
        this.sumCol="sell_end";
        return this;
    }

    public StockInfoSnalysisExample sumIsend() {
        this.sumCol="isend";
        return this;
    }

    public StockInfoSnalysisExample sumCreateDate() {
        this.sumCol="create_date";
        return this;
    }

    public StockInfoSnalysisExample sumUpdateDate() {
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

    public StockInfoSnalysisExample page(int offset, int limit) {
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

        public Criteria andDiffIsNull() {
            addCriterion("diff is null");
            return (Criteria) this;
        }

        public Criteria andDiffIsNotNull() {
            addCriterion("diff is not null");
            return (Criteria) this;
        }

        public Criteria andDiffEqualTo(Float value) {
            addCriterion("diff =", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffNotEqualTo(Float value) {
            addCriterion("diff <>", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffGreaterThan(Float value) {
            addCriterion("diff >", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffGreaterThanOrEqualTo(Float value) {
            addCriterion("diff >=", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffLessThan(Float value) {
            addCriterion("diff <", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffLessThanOrEqualTo(Float value) {
            addCriterion("diff <=", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffIn(List<Float> values) {
            addCriterion("diff in", values, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffNotIn(List<Float> values) {
            addCriterion("diff not in", values, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffBetween(Float value1, Float value2) {
            addCriterion("diff between", value1, value2, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffNotBetween(Float value1, Float value2) {
            addCriterion("diff not between", value1, value2, "diff");
            return (Criteria) this;
        }

        public Criteria andDiff3IsNull() {
            addCriterion("diff3 is null");
            return (Criteria) this;
        }

        public Criteria andDiff3IsNotNull() {
            addCriterion("diff3 is not null");
            return (Criteria) this;
        }

        public Criteria andDiff3EqualTo(Float value) {
            addCriterion("diff3 =", value, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3NotEqualTo(Float value) {
            addCriterion("diff3 <>", value, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3GreaterThan(Float value) {
            addCriterion("diff3 >", value, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3GreaterThanOrEqualTo(Float value) {
            addCriterion("diff3 >=", value, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3LessThan(Float value) {
            addCriterion("diff3 <", value, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3LessThanOrEqualTo(Float value) {
            addCriterion("diff3 <=", value, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3In(List<Float> values) {
            addCriterion("diff3 in", values, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3NotIn(List<Float> values) {
            addCriterion("diff3 not in", values, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3Between(Float value1, Float value2) {
            addCriterion("diff3 between", value1, value2, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff3NotBetween(Float value1, Float value2) {
            addCriterion("diff3 not between", value1, value2, "diff3");
            return (Criteria) this;
        }

        public Criteria andDiff5IsNull() {
            addCriterion("diff5 is null");
            return (Criteria) this;
        }

        public Criteria andDiff5IsNotNull() {
            addCriterion("diff5 is not null");
            return (Criteria) this;
        }

        public Criteria andDiff5EqualTo(Float value) {
            addCriterion("diff5 =", value, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5NotEqualTo(Float value) {
            addCriterion("diff5 <>", value, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5GreaterThan(Float value) {
            addCriterion("diff5 >", value, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5GreaterThanOrEqualTo(Float value) {
            addCriterion("diff5 >=", value, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5LessThan(Float value) {
            addCriterion("diff5 <", value, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5LessThanOrEqualTo(Float value) {
            addCriterion("diff5 <=", value, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5In(List<Float> values) {
            addCriterion("diff5 in", values, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5NotIn(List<Float> values) {
            addCriterion("diff5 not in", values, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5Between(Float value1, Float value2) {
            addCriterion("diff5 between", value1, value2, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff5NotBetween(Float value1, Float value2) {
            addCriterion("diff5 not between", value1, value2, "diff5");
            return (Criteria) this;
        }

        public Criteria andDiff30IsNull() {
            addCriterion("diff30 is null");
            return (Criteria) this;
        }

        public Criteria andDiff30IsNotNull() {
            addCriterion("diff30 is not null");
            return (Criteria) this;
        }

        public Criteria andDiff30EqualTo(Float value) {
            addCriterion("diff30 =", value, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30NotEqualTo(Float value) {
            addCriterion("diff30 <>", value, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30GreaterThan(Float value) {
            addCriterion("diff30 >", value, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30GreaterThanOrEqualTo(Float value) {
            addCriterion("diff30 >=", value, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30LessThan(Float value) {
            addCriterion("diff30 <", value, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30LessThanOrEqualTo(Float value) {
            addCriterion("diff30 <=", value, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30In(List<Float> values) {
            addCriterion("diff30 in", values, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30NotIn(List<Float> values) {
            addCriterion("diff30 not in", values, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30Between(Float value1, Float value2) {
            addCriterion("diff30 between", value1, value2, "diff30");
            return (Criteria) this;
        }

        public Criteria andDiff30NotBetween(Float value1, Float value2) {
            addCriterion("diff30 not between", value1, value2, "diff30");
            return (Criteria) this;
        }

        public Criteria andLastDateIsNull() {
            addCriterion("last_date is null");
            return (Criteria) this;
        }

        public Criteria andLastDateIsNotNull() {
            addCriterion("last_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastDateEqualTo(Integer value) {
            addCriterion("last_date =", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotEqualTo(Integer value) {
            addCriterion("last_date <>", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateGreaterThan(Integer value) {
            addCriterion("last_date >", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_date >=", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateLessThan(Integer value) {
            addCriterion("last_date <", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateLessThanOrEqualTo(Integer value) {
            addCriterion("last_date <=", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateIn(List<Integer> values) {
            addCriterion("last_date in", values, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotIn(List<Integer> values) {
            addCriterion("last_date not in", values, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateBetween(Integer value1, Integer value2) {
            addCriterion("last_date between", value1, value2, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotBetween(Integer value1, Integer value2) {
            addCriterion("last_date not between", value1, value2, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastOpenIsNull() {
            addCriterion("last_open is null");
            return (Criteria) this;
        }

        public Criteria andLastOpenIsNotNull() {
            addCriterion("last_open is not null");
            return (Criteria) this;
        }

        public Criteria andLastOpenEqualTo(Float value) {
            addCriterion("last_open =", value, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenNotEqualTo(Float value) {
            addCriterion("last_open <>", value, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenGreaterThan(Float value) {
            addCriterion("last_open >", value, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenGreaterThanOrEqualTo(Float value) {
            addCriterion("last_open >=", value, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenLessThan(Float value) {
            addCriterion("last_open <", value, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenLessThanOrEqualTo(Float value) {
            addCriterion("last_open <=", value, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenIn(List<Float> values) {
            addCriterion("last_open in", values, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenNotIn(List<Float> values) {
            addCriterion("last_open not in", values, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenBetween(Float value1, Float value2) {
            addCriterion("last_open between", value1, value2, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastOpenNotBetween(Float value1, Float value2) {
            addCriterion("last_open not between", value1, value2, "lastOpen");
            return (Criteria) this;
        }

        public Criteria andLastHighIsNull() {
            addCriterion("last_high is null");
            return (Criteria) this;
        }

        public Criteria andLastHighIsNotNull() {
            addCriterion("last_high is not null");
            return (Criteria) this;
        }

        public Criteria andLastHighEqualTo(Float value) {
            addCriterion("last_high =", value, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighNotEqualTo(Float value) {
            addCriterion("last_high <>", value, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighGreaterThan(Float value) {
            addCriterion("last_high >", value, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighGreaterThanOrEqualTo(Float value) {
            addCriterion("last_high >=", value, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighLessThan(Float value) {
            addCriterion("last_high <", value, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighLessThanOrEqualTo(Float value) {
            addCriterion("last_high <=", value, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighIn(List<Float> values) {
            addCriterion("last_high in", values, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighNotIn(List<Float> values) {
            addCriterion("last_high not in", values, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighBetween(Float value1, Float value2) {
            addCriterion("last_high between", value1, value2, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastHighNotBetween(Float value1, Float value2) {
            addCriterion("last_high not between", value1, value2, "lastHigh");
            return (Criteria) this;
        }

        public Criteria andLastCloseIsNull() {
            addCriterion("last_close is null");
            return (Criteria) this;
        }

        public Criteria andLastCloseIsNotNull() {
            addCriterion("last_close is not null");
            return (Criteria) this;
        }

        public Criteria andLastCloseEqualTo(Float value) {
            addCriterion("last_close =", value, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseNotEqualTo(Float value) {
            addCriterion("last_close <>", value, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseGreaterThan(Float value) {
            addCriterion("last_close >", value, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseGreaterThanOrEqualTo(Float value) {
            addCriterion("last_close >=", value, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseLessThan(Float value) {
            addCriterion("last_close <", value, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseLessThanOrEqualTo(Float value) {
            addCriterion("last_close <=", value, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseIn(List<Float> values) {
            addCriterion("last_close in", values, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseNotIn(List<Float> values) {
            addCriterion("last_close not in", values, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseBetween(Float value1, Float value2) {
            addCriterion("last_close between", value1, value2, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastCloseNotBetween(Float value1, Float value2) {
            addCriterion("last_close not between", value1, value2, "lastClose");
            return (Criteria) this;
        }

        public Criteria andLastLowIsNull() {
            addCriterion("last_low is null");
            return (Criteria) this;
        }

        public Criteria andLastLowIsNotNull() {
            addCriterion("last_low is not null");
            return (Criteria) this;
        }

        public Criteria andLastLowEqualTo(Float value) {
            addCriterion("last_low =", value, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowNotEqualTo(Float value) {
            addCriterion("last_low <>", value, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowGreaterThan(Float value) {
            addCriterion("last_low >", value, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowGreaterThanOrEqualTo(Float value) {
            addCriterion("last_low >=", value, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowLessThan(Float value) {
            addCriterion("last_low <", value, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowLessThanOrEqualTo(Float value) {
            addCriterion("last_low <=", value, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowIn(List<Float> values) {
            addCriterion("last_low in", values, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowNotIn(List<Float> values) {
            addCriterion("last_low not in", values, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowBetween(Float value1, Float value2) {
            addCriterion("last_low between", value1, value2, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastLowNotBetween(Float value1, Float value2) {
            addCriterion("last_low not between", value1, value2, "lastLow");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIsNull() {
            addCriterion("last_volume is null");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIsNotNull() {
            addCriterion("last_volume is not null");
            return (Criteria) this;
        }

        public Criteria andLastVolumeEqualTo(Long value) {
            addCriterion("last_volume =", value, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeNotEqualTo(Long value) {
            addCriterion("last_volume <>", value, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeGreaterThan(Long value) {
            addCriterion("last_volume >", value, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_volume >=", value, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeLessThan(Long value) {
            addCriterion("last_volume <", value, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeLessThanOrEqualTo(Long value) {
            addCriterion("last_volume <=", value, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIn(List<Long> values) {
            addCriterion("last_volume in", values, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeNotIn(List<Long> values) {
            addCriterion("last_volume not in", values, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeBetween(Long value1, Long value2) {
            addCriterion("last_volume between", value1, value2, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastVolumeNotBetween(Long value1, Long value2) {
            addCriterion("last_volume not between", value1, value2, "lastVolume");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexIsNull() {
            addCriterion("last_open_index is null");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexIsNotNull() {
            addCriterion("last_open_index is not null");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexEqualTo(Integer value) {
            addCriterion("last_open_index =", value, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexNotEqualTo(Integer value) {
            addCriterion("last_open_index <>", value, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexGreaterThan(Integer value) {
            addCriterion("last_open_index >", value, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_open_index >=", value, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexLessThan(Integer value) {
            addCriterion("last_open_index <", value, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexLessThanOrEqualTo(Integer value) {
            addCriterion("last_open_index <=", value, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexIn(List<Integer> values) {
            addCriterion("last_open_index in", values, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexNotIn(List<Integer> values) {
            addCriterion("last_open_index not in", values, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexBetween(Integer value1, Integer value2) {
            addCriterion("last_open_index between", value1, value2, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastOpenIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("last_open_index not between", value1, value2, "lastOpenIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexIsNull() {
            addCriterion("last_high_index is null");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexIsNotNull() {
            addCriterion("last_high_index is not null");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexEqualTo(Integer value) {
            addCriterion("last_high_index =", value, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexNotEqualTo(Integer value) {
            addCriterion("last_high_index <>", value, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexGreaterThan(Integer value) {
            addCriterion("last_high_index >", value, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_high_index >=", value, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexLessThan(Integer value) {
            addCriterion("last_high_index <", value, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexLessThanOrEqualTo(Integer value) {
            addCriterion("last_high_index <=", value, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexIn(List<Integer> values) {
            addCriterion("last_high_index in", values, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexNotIn(List<Integer> values) {
            addCriterion("last_high_index not in", values, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexBetween(Integer value1, Integer value2) {
            addCriterion("last_high_index between", value1, value2, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastHighIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("last_high_index not between", value1, value2, "lastHighIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexIsNull() {
            addCriterion("last_low_index is null");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexIsNotNull() {
            addCriterion("last_low_index is not null");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexEqualTo(Integer value) {
            addCriterion("last_low_index =", value, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexNotEqualTo(Integer value) {
            addCriterion("last_low_index <>", value, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexGreaterThan(Integer value) {
            addCriterion("last_low_index >", value, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_low_index >=", value, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexLessThan(Integer value) {
            addCriterion("last_low_index <", value, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("last_low_index <=", value, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexIn(List<Integer> values) {
            addCriterion("last_low_index in", values, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexNotIn(List<Integer> values) {
            addCriterion("last_low_index not in", values, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexBetween(Integer value1, Integer value2) {
            addCriterion("last_low_index between", value1, value2, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastLowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("last_low_index not between", value1, value2, "lastLowIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexIsNull() {
            addCriterion("last_close_index is null");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexIsNotNull() {
            addCriterion("last_close_index is not null");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexEqualTo(Integer value) {
            addCriterion("last_close_index =", value, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexNotEqualTo(Integer value) {
            addCriterion("last_close_index <>", value, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexGreaterThan(Integer value) {
            addCriterion("last_close_index >", value, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_close_index >=", value, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexLessThan(Integer value) {
            addCriterion("last_close_index <", value, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexLessThanOrEqualTo(Integer value) {
            addCriterion("last_close_index <=", value, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexIn(List<Integer> values) {
            addCriterion("last_close_index in", values, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexNotIn(List<Integer> values) {
            addCriterion("last_close_index not in", values, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexBetween(Integer value1, Integer value2) {
            addCriterion("last_close_index between", value1, value2, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("last_close_index not between", value1, value2, "lastCloseIndex");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtIsNull() {
            addCriterion("last_close_weght is null");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtIsNotNull() {
            addCriterion("last_close_weght is not null");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtEqualTo(Float value) {
            addCriterion("last_close_weght =", value, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtNotEqualTo(Float value) {
            addCriterion("last_close_weght <>", value, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtGreaterThan(Float value) {
            addCriterion("last_close_weght >", value, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtGreaterThanOrEqualTo(Float value) {
            addCriterion("last_close_weght >=", value, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtLessThan(Float value) {
            addCriterion("last_close_weght <", value, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtLessThanOrEqualTo(Float value) {
            addCriterion("last_close_weght <=", value, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtIn(List<Float> values) {
            addCriterion("last_close_weght in", values, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtNotIn(List<Float> values) {
            addCriterion("last_close_weght not in", values, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtBetween(Float value1, Float value2) {
            addCriterion("last_close_weght between", value1, value2, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastCloseWeghtNotBetween(Float value1, Float value2) {
            addCriterion("last_close_weght not between", value1, value2, "lastCloseWeght");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexIsNull() {
            addCriterion("last_volume_index is null");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexIsNotNull() {
            addCriterion("last_volume_index is not null");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexEqualTo(Integer value) {
            addCriterion("last_volume_index =", value, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexNotEqualTo(Integer value) {
            addCriterion("last_volume_index <>", value, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexGreaterThan(Integer value) {
            addCriterion("last_volume_index >", value, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_volume_index >=", value, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexLessThan(Integer value) {
            addCriterion("last_volume_index <", value, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexLessThanOrEqualTo(Integer value) {
            addCriterion("last_volume_index <=", value, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexIn(List<Integer> values) {
            addCriterion("last_volume_index in", values, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexNotIn(List<Integer> values) {
            addCriterion("last_volume_index not in", values, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexBetween(Integer value1, Integer value2) {
            addCriterion("last_volume_index between", value1, value2, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andLastVolumeIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("last_volume_index not between", value1, value2, "lastVolumeIndex");
            return (Criteria) this;
        }

        public Criteria andBaseNumberIsNull() {
            addCriterion("base_number is null");
            return (Criteria) this;
        }

        public Criteria andBaseNumberIsNotNull() {
            addCriterion("base_number is not null");
            return (Criteria) this;
        }

        public Criteria andBaseNumberEqualTo(Integer value) {
            addCriterion("base_number =", value, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberNotEqualTo(Integer value) {
            addCriterion("base_number <>", value, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberGreaterThan(Integer value) {
            addCriterion("base_number >", value, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_number >=", value, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberLessThan(Integer value) {
            addCriterion("base_number <", value, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberLessThanOrEqualTo(Integer value) {
            addCriterion("base_number <=", value, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberIn(List<Integer> values) {
            addCriterion("base_number in", values, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberNotIn(List<Integer> values) {
            addCriterion("base_number not in", values, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberBetween(Integer value1, Integer value2) {
            addCriterion("base_number between", value1, value2, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andBaseNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("base_number not between", value1, value2, "baseNumber");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIsNull() {
            addCriterion("average_price is null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIsNotNull() {
            addCriterion("average_price is not null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceEqualTo(Float value) {
            addCriterion("average_price =", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotEqualTo(Float value) {
            addCriterion("average_price <>", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThan(Float value) {
            addCriterion("average_price >", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("average_price >=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThan(Float value) {
            addCriterion("average_price <", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThanOrEqualTo(Float value) {
            addCriterion("average_price <=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIn(List<Float> values) {
            addCriterion("average_price in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotIn(List<Float> values) {
            addCriterion("average_price not in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceBetween(Float value1, Float value2) {
            addCriterion("average_price between", value1, value2, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotBetween(Float value1, Float value2) {
            addCriterion("average_price not between", value1, value2, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceIsNull() {
            addCriterion("high_price is null");
            return (Criteria) this;
        }

        public Criteria andHighPriceIsNotNull() {
            addCriterion("high_price is not null");
            return (Criteria) this;
        }

        public Criteria andHighPriceEqualTo(Float value) {
            addCriterion("high_price =", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotEqualTo(Float value) {
            addCriterion("high_price <>", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceGreaterThan(Float value) {
            addCriterion("high_price >", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("high_price >=", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceLessThan(Float value) {
            addCriterion("high_price <", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceLessThanOrEqualTo(Float value) {
            addCriterion("high_price <=", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceIn(List<Float> values) {
            addCriterion("high_price in", values, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotIn(List<Float> values) {
            addCriterion("high_price not in", values, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceBetween(Float value1, Float value2) {
            addCriterion("high_price between", value1, value2, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotBetween(Float value1, Float value2) {
            addCriterion("high_price not between", value1, value2, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighIndexIsNull() {
            addCriterion("high_index is null");
            return (Criteria) this;
        }

        public Criteria andHighIndexIsNotNull() {
            addCriterion("high_index is not null");
            return (Criteria) this;
        }

        public Criteria andHighIndexEqualTo(Integer value) {
            addCriterion("high_index =", value, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexNotEqualTo(Integer value) {
            addCriterion("high_index <>", value, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexGreaterThan(Integer value) {
            addCriterion("high_index >", value, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_index >=", value, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexLessThan(Integer value) {
            addCriterion("high_index <", value, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexLessThanOrEqualTo(Integer value) {
            addCriterion("high_index <=", value, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexIn(List<Integer> values) {
            addCriterion("high_index in", values, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexNotIn(List<Integer> values) {
            addCriterion("high_index not in", values, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexBetween(Integer value1, Integer value2) {
            addCriterion("high_index between", value1, value2, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("high_index not between", value1, value2, "highIndex");
            return (Criteria) this;
        }

        public Criteria andHighDayIsNull() {
            addCriterion("high_day is null");
            return (Criteria) this;
        }

        public Criteria andHighDayIsNotNull() {
            addCriterion("high_day is not null");
            return (Criteria) this;
        }

        public Criteria andHighDayEqualTo(Integer value) {
            addCriterion("high_day =", value, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayNotEqualTo(Integer value) {
            addCriterion("high_day <>", value, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayGreaterThan(Integer value) {
            addCriterion("high_day >", value, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_day >=", value, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayLessThan(Integer value) {
            addCriterion("high_day <", value, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayLessThanOrEqualTo(Integer value) {
            addCriterion("high_day <=", value, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayIn(List<Integer> values) {
            addCriterion("high_day in", values, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayNotIn(List<Integer> values) {
            addCriterion("high_day not in", values, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayBetween(Integer value1, Integer value2) {
            addCriterion("high_day between", value1, value2, "highDay");
            return (Criteria) this;
        }

        public Criteria andHighDayNotBetween(Integer value1, Integer value2) {
            addCriterion("high_day not between", value1, value2, "highDay");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNull() {
            addCriterion("low_price is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNotNull() {
            addCriterion("low_price is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceEqualTo(Float value) {
            addCriterion("low_price =", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotEqualTo(Float value) {
            addCriterion("low_price <>", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThan(Float value) {
            addCriterion("low_price >", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("low_price >=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThan(Float value) {
            addCriterion("low_price <", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThanOrEqualTo(Float value) {
            addCriterion("low_price <=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceIn(List<Float> values) {
            addCriterion("low_price in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotIn(List<Float> values) {
            addCriterion("low_price not in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceBetween(Float value1, Float value2) {
            addCriterion("low_price between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotBetween(Float value1, Float value2) {
            addCriterion("low_price not between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowIndexIsNull() {
            addCriterion("low_index is null");
            return (Criteria) this;
        }

        public Criteria andLowIndexIsNotNull() {
            addCriterion("low_index is not null");
            return (Criteria) this;
        }

        public Criteria andLowIndexEqualTo(Integer value) {
            addCriterion("low_index =", value, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexNotEqualTo(Integer value) {
            addCriterion("low_index <>", value, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexGreaterThan(Integer value) {
            addCriterion("low_index >", value, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_index >=", value, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexLessThan(Integer value) {
            addCriterion("low_index <", value, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("low_index <=", value, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexIn(List<Integer> values) {
            addCriterion("low_index in", values, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexNotIn(List<Integer> values) {
            addCriterion("low_index not in", values, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexBetween(Integer value1, Integer value2) {
            addCriterion("low_index between", value1, value2, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("low_index not between", value1, value2, "lowIndex");
            return (Criteria) this;
        }

        public Criteria andLowDayIsNull() {
            addCriterion("low_day is null");
            return (Criteria) this;
        }

        public Criteria andLowDayIsNotNull() {
            addCriterion("low_day is not null");
            return (Criteria) this;
        }

        public Criteria andLowDayEqualTo(Integer value) {
            addCriterion("low_day =", value, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayNotEqualTo(Integer value) {
            addCriterion("low_day <>", value, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayGreaterThan(Integer value) {
            addCriterion("low_day >", value, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_day >=", value, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayLessThan(Integer value) {
            addCriterion("low_day <", value, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayLessThanOrEqualTo(Integer value) {
            addCriterion("low_day <=", value, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayIn(List<Integer> values) {
            addCriterion("low_day in", values, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayNotIn(List<Integer> values) {
            addCriterion("low_day not in", values, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayBetween(Integer value1, Integer value2) {
            addCriterion("low_day between", value1, value2, "lowDay");
            return (Criteria) this;
        }

        public Criteria andLowDayNotBetween(Integer value1, Integer value2) {
            addCriterion("low_day not between", value1, value2, "lowDay");
            return (Criteria) this;
        }

        public Criteria andContinueDaysIsNull() {
            addCriterion("continue_days is null");
            return (Criteria) this;
        }

        public Criteria andContinueDaysIsNotNull() {
            addCriterion("continue_days is not null");
            return (Criteria) this;
        }

        public Criteria andContinueDaysEqualTo(Integer value) {
            addCriterion("continue_days =", value, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysNotEqualTo(Integer value) {
            addCriterion("continue_days <>", value, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysGreaterThan(Integer value) {
            addCriterion("continue_days >", value, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("continue_days >=", value, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysLessThan(Integer value) {
            addCriterion("continue_days <", value, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysLessThanOrEqualTo(Integer value) {
            addCriterion("continue_days <=", value, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysIn(List<Integer> values) {
            addCriterion("continue_days in", values, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysNotIn(List<Integer> values) {
            addCriterion("continue_days not in", values, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysBetween(Integer value1, Integer value2) {
            addCriterion("continue_days between", value1, value2, "continueDays");
            return (Criteria) this;
        }

        public Criteria andContinueDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("continue_days not between", value1, value2, "continueDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysIsNull() {
            addCriterion("rising_days is null");
            return (Criteria) this;
        }

        public Criteria andRisingDaysIsNotNull() {
            addCriterion("rising_days is not null");
            return (Criteria) this;
        }

        public Criteria andRisingDaysEqualTo(Integer value) {
            addCriterion("rising_days =", value, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNotEqualTo(Integer value) {
            addCriterion("rising_days <>", value, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysGreaterThan(Integer value) {
            addCriterion("rising_days >", value, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("rising_days >=", value, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysLessThan(Integer value) {
            addCriterion("rising_days <", value, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysLessThanOrEqualTo(Integer value) {
            addCriterion("rising_days <=", value, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysIn(List<Integer> values) {
            addCriterion("rising_days in", values, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNotIn(List<Integer> values) {
            addCriterion("rising_days not in", values, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysBetween(Integer value1, Integer value2) {
            addCriterion("rising_days between", value1, value2, "risingDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("rising_days not between", value1, value2, "risingDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysIsNull() {
            addCriterion("fall_days is null");
            return (Criteria) this;
        }

        public Criteria andFallDaysIsNotNull() {
            addCriterion("fall_days is not null");
            return (Criteria) this;
        }

        public Criteria andFallDaysEqualTo(Integer value) {
            addCriterion("fall_days =", value, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysNotEqualTo(Integer value) {
            addCriterion("fall_days <>", value, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysGreaterThan(Integer value) {
            addCriterion("fall_days >", value, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("fall_days >=", value, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysLessThan(Integer value) {
            addCriterion("fall_days <", value, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysLessThanOrEqualTo(Integer value) {
            addCriterion("fall_days <=", value, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysIn(List<Integer> values) {
            addCriterion("fall_days in", values, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysNotIn(List<Integer> values) {
            addCriterion("fall_days not in", values, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysBetween(Integer value1, Integer value2) {
            addCriterion("fall_days between", value1, value2, "fallDays");
            return (Criteria) this;
        }

        public Criteria andFallDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("fall_days not between", value1, value2, "fallDays");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearIsNull() {
            addCriterion("rising_days_near is null");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearIsNotNull() {
            addCriterion("rising_days_near is not null");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearEqualTo(Integer value) {
            addCriterion("rising_days_near =", value, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearNotEqualTo(Integer value) {
            addCriterion("rising_days_near <>", value, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearGreaterThan(Integer value) {
            addCriterion("rising_days_near >", value, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearGreaterThanOrEqualTo(Integer value) {
            addCriterion("rising_days_near >=", value, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearLessThan(Integer value) {
            addCriterion("rising_days_near <", value, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearLessThanOrEqualTo(Integer value) {
            addCriterion("rising_days_near <=", value, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearIn(List<Integer> values) {
            addCriterion("rising_days_near in", values, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearNotIn(List<Integer> values) {
            addCriterion("rising_days_near not in", values, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearBetween(Integer value1, Integer value2) {
            addCriterion("rising_days_near between", value1, value2, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andRisingDaysNearNotBetween(Integer value1, Integer value2) {
            addCriterion("rising_days_near not between", value1, value2, "risingDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearIsNull() {
            addCriterion("fall_days_near is null");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearIsNotNull() {
            addCriterion("fall_days_near is not null");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearEqualTo(Integer value) {
            addCriterion("fall_days_near =", value, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearNotEqualTo(Integer value) {
            addCriterion("fall_days_near <>", value, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearGreaterThan(Integer value) {
            addCriterion("fall_days_near >", value, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearGreaterThanOrEqualTo(Integer value) {
            addCriterion("fall_days_near >=", value, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearLessThan(Integer value) {
            addCriterion("fall_days_near <", value, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearLessThanOrEqualTo(Integer value) {
            addCriterion("fall_days_near <=", value, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearIn(List<Integer> values) {
            addCriterion("fall_days_near in", values, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearNotIn(List<Integer> values) {
            addCriterion("fall_days_near not in", values, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearBetween(Integer value1, Integer value2) {
            addCriterion("fall_days_near between", value1, value2, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andFallDaysNearNotBetween(Integer value1, Integer value2) {
            addCriterion("fall_days_near not between", value1, value2, "fallDaysNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearIsNull() {
            addCriterion("high_price_near is null");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearIsNotNull() {
            addCriterion("high_price_near is not null");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearEqualTo(Float value) {
            addCriterion("high_price_near =", value, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearNotEqualTo(Float value) {
            addCriterion("high_price_near <>", value, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearGreaterThan(Float value) {
            addCriterion("high_price_near >", value, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearGreaterThanOrEqualTo(Float value) {
            addCriterion("high_price_near >=", value, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearLessThan(Float value) {
            addCriterion("high_price_near <", value, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearLessThanOrEqualTo(Float value) {
            addCriterion("high_price_near <=", value, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearIn(List<Float> values) {
            addCriterion("high_price_near in", values, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearNotIn(List<Float> values) {
            addCriterion("high_price_near not in", values, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearBetween(Float value1, Float value2) {
            addCriterion("high_price_near between", value1, value2, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighPriceNearNotBetween(Float value1, Float value2) {
            addCriterion("high_price_near not between", value1, value2, "highPriceNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearIsNull() {
            addCriterion("high_index_near is null");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearIsNotNull() {
            addCriterion("high_index_near is not null");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearEqualTo(Integer value) {
            addCriterion("high_index_near =", value, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearNotEqualTo(Integer value) {
            addCriterion("high_index_near <>", value, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearGreaterThan(Integer value) {
            addCriterion("high_index_near >", value, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_index_near >=", value, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearLessThan(Integer value) {
            addCriterion("high_index_near <", value, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearLessThanOrEqualTo(Integer value) {
            addCriterion("high_index_near <=", value, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearIn(List<Integer> values) {
            addCriterion("high_index_near in", values, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearNotIn(List<Integer> values) {
            addCriterion("high_index_near not in", values, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearBetween(Integer value1, Integer value2) {
            addCriterion("high_index_near between", value1, value2, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighIndexNearNotBetween(Integer value1, Integer value2) {
            addCriterion("high_index_near not between", value1, value2, "highIndexNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearIsNull() {
            addCriterion("high_day_near is null");
            return (Criteria) this;
        }

        public Criteria andHighDayNearIsNotNull() {
            addCriterion("high_day_near is not null");
            return (Criteria) this;
        }

        public Criteria andHighDayNearEqualTo(Integer value) {
            addCriterion("high_day_near =", value, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearNotEqualTo(Integer value) {
            addCriterion("high_day_near <>", value, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearGreaterThan(Integer value) {
            addCriterion("high_day_near >", value, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_day_near >=", value, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearLessThan(Integer value) {
            addCriterion("high_day_near <", value, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearLessThanOrEqualTo(Integer value) {
            addCriterion("high_day_near <=", value, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearIn(List<Integer> values) {
            addCriterion("high_day_near in", values, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearNotIn(List<Integer> values) {
            addCriterion("high_day_near not in", values, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearBetween(Integer value1, Integer value2) {
            addCriterion("high_day_near between", value1, value2, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andHighDayNearNotBetween(Integer value1, Integer value2) {
            addCriterion("high_day_near not between", value1, value2, "highDayNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearIsNull() {
            addCriterion("low_price_near is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearIsNotNull() {
            addCriterion("low_price_near is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearEqualTo(Float value) {
            addCriterion("low_price_near =", value, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearNotEqualTo(Float value) {
            addCriterion("low_price_near <>", value, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearGreaterThan(Float value) {
            addCriterion("low_price_near >", value, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearGreaterThanOrEqualTo(Float value) {
            addCriterion("low_price_near >=", value, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearLessThan(Float value) {
            addCriterion("low_price_near <", value, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearLessThanOrEqualTo(Float value) {
            addCriterion("low_price_near <=", value, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearIn(List<Float> values) {
            addCriterion("low_price_near in", values, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearNotIn(List<Float> values) {
            addCriterion("low_price_near not in", values, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearBetween(Float value1, Float value2) {
            addCriterion("low_price_near between", value1, value2, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowPriceNearNotBetween(Float value1, Float value2) {
            addCriterion("low_price_near not between", value1, value2, "lowPriceNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearIsNull() {
            addCriterion("low_index_near is null");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearIsNotNull() {
            addCriterion("low_index_near is not null");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearEqualTo(Integer value) {
            addCriterion("low_index_near =", value, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearNotEqualTo(Integer value) {
            addCriterion("low_index_near <>", value, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearGreaterThan(Integer value) {
            addCriterion("low_index_near >", value, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_index_near >=", value, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearLessThan(Integer value) {
            addCriterion("low_index_near <", value, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearLessThanOrEqualTo(Integer value) {
            addCriterion("low_index_near <=", value, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearIn(List<Integer> values) {
            addCriterion("low_index_near in", values, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearNotIn(List<Integer> values) {
            addCriterion("low_index_near not in", values, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearBetween(Integer value1, Integer value2) {
            addCriterion("low_index_near between", value1, value2, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowIndexNearNotBetween(Integer value1, Integer value2) {
            addCriterion("low_index_near not between", value1, value2, "lowIndexNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearIsNull() {
            addCriterion("low_day_near is null");
            return (Criteria) this;
        }

        public Criteria andLowDayNearIsNotNull() {
            addCriterion("low_day_near is not null");
            return (Criteria) this;
        }

        public Criteria andLowDayNearEqualTo(Integer value) {
            addCriterion("low_day_near =", value, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearNotEqualTo(Integer value) {
            addCriterion("low_day_near <>", value, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearGreaterThan(Integer value) {
            addCriterion("low_day_near >", value, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_day_near >=", value, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearLessThan(Integer value) {
            addCriterion("low_day_near <", value, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearLessThanOrEqualTo(Integer value) {
            addCriterion("low_day_near <=", value, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearIn(List<Integer> values) {
            addCriterion("low_day_near in", values, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearNotIn(List<Integer> values) {
            addCriterion("low_day_near not in", values, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearBetween(Integer value1, Integer value2) {
            addCriterion("low_day_near between", value1, value2, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andLowDayNearNotBetween(Integer value1, Integer value2) {
            addCriterion("low_day_near not between", value1, value2, "lowDayNear");
            return (Criteria) this;
        }

        public Criteria andBuyStartIsNull() {
            addCriterion("buy_start is null");
            return (Criteria) this;
        }

        public Criteria andBuyStartIsNotNull() {
            addCriterion("buy_start is not null");
            return (Criteria) this;
        }

        public Criteria andBuyStartEqualTo(Integer value) {
            addCriterion("buy_start =", value, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartNotEqualTo(Integer value) {
            addCriterion("buy_start <>", value, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartGreaterThan(Integer value) {
            addCriterion("buy_start >", value, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_start >=", value, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartLessThan(Integer value) {
            addCriterion("buy_start <", value, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartLessThanOrEqualTo(Integer value) {
            addCriterion("buy_start <=", value, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartIn(List<Integer> values) {
            addCriterion("buy_start in", values, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartNotIn(List<Integer> values) {
            addCriterion("buy_start not in", values, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartBetween(Integer value1, Integer value2) {
            addCriterion("buy_start between", value1, value2, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyStartNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_start not between", value1, value2, "buyStart");
            return (Criteria) this;
        }

        public Criteria andBuyEndIsNull() {
            addCriterion("buy_end is null");
            return (Criteria) this;
        }

        public Criteria andBuyEndIsNotNull() {
            addCriterion("buy_end is not null");
            return (Criteria) this;
        }

        public Criteria andBuyEndEqualTo(Integer value) {
            addCriterion("buy_end =", value, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndNotEqualTo(Integer value) {
            addCriterion("buy_end <>", value, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndGreaterThan(Integer value) {
            addCriterion("buy_end >", value, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_end >=", value, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndLessThan(Integer value) {
            addCriterion("buy_end <", value, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndLessThanOrEqualTo(Integer value) {
            addCriterion("buy_end <=", value, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndIn(List<Integer> values) {
            addCriterion("buy_end in", values, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndNotIn(List<Integer> values) {
            addCriterion("buy_end not in", values, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndBetween(Integer value1, Integer value2) {
            addCriterion("buy_end between", value1, value2, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andBuyEndNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_end not between", value1, value2, "buyEnd");
            return (Criteria) this;
        }

        public Criteria andSellStartIsNull() {
            addCriterion("sell_start is null");
            return (Criteria) this;
        }

        public Criteria andSellStartIsNotNull() {
            addCriterion("sell_start is not null");
            return (Criteria) this;
        }

        public Criteria andSellStartEqualTo(Integer value) {
            addCriterion("sell_start =", value, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartNotEqualTo(Integer value) {
            addCriterion("sell_start <>", value, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartGreaterThan(Integer value) {
            addCriterion("sell_start >", value, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_start >=", value, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartLessThan(Integer value) {
            addCriterion("sell_start <", value, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartLessThanOrEqualTo(Integer value) {
            addCriterion("sell_start <=", value, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartIn(List<Integer> values) {
            addCriterion("sell_start in", values, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartNotIn(List<Integer> values) {
            addCriterion("sell_start not in", values, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartBetween(Integer value1, Integer value2) {
            addCriterion("sell_start between", value1, value2, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellStartNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_start not between", value1, value2, "sellStart");
            return (Criteria) this;
        }

        public Criteria andSellEndIsNull() {
            addCriterion("sell_end is null");
            return (Criteria) this;
        }

        public Criteria andSellEndIsNotNull() {
            addCriterion("sell_end is not null");
            return (Criteria) this;
        }

        public Criteria andSellEndEqualTo(Integer value) {
            addCriterion("sell_end =", value, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndNotEqualTo(Integer value) {
            addCriterion("sell_end <>", value, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndGreaterThan(Integer value) {
            addCriterion("sell_end >", value, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_end >=", value, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndLessThan(Integer value) {
            addCriterion("sell_end <", value, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndLessThanOrEqualTo(Integer value) {
            addCriterion("sell_end <=", value, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndIn(List<Integer> values) {
            addCriterion("sell_end in", values, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndNotIn(List<Integer> values) {
            addCriterion("sell_end not in", values, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndBetween(Integer value1, Integer value2) {
            addCriterion("sell_end between", value1, value2, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andSellEndNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_end not between", value1, value2, "sellEnd");
            return (Criteria) this;
        }

        public Criteria andIsendIsNull() {
            addCriterion("isend is null");
            return (Criteria) this;
        }

        public Criteria andIsendIsNotNull() {
            addCriterion("isend is not null");
            return (Criteria) this;
        }

        public Criteria andIsendEqualTo(Integer value) {
            addCriterion("isend =", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotEqualTo(Integer value) {
            addCriterion("isend <>", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendGreaterThan(Integer value) {
            addCriterion("isend >", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendGreaterThanOrEqualTo(Integer value) {
            addCriterion("isend >=", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendLessThan(Integer value) {
            addCriterion("isend <", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendLessThanOrEqualTo(Integer value) {
            addCriterion("isend <=", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendIn(List<Integer> values) {
            addCriterion("isend in", values, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotIn(List<Integer> values) {
            addCriterion("isend not in", values, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendBetween(Integer value1, Integer value2) {
            addCriterion("isend between", value1, value2, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotBetween(Integer value1, Integer value2) {
            addCriterion("isend not between", value1, value2, "isend");
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