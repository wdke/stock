package com.wdke.stock.storage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockInfoMonthDiffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public StockInfoMonthDiffExample() {
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

    public StockInfoMonthDiffExample sumStockCode() {
        this.sumCol="stock_code";
        return this;
    }

    public StockInfoMonthDiffExample sumStockType() {
        this.sumCol="stock_type";
        return this;
    }

    public StockInfoMonthDiffExample sumYear() {
        this.sumCol="year";
        return this;
    }

    public StockInfoMonthDiffExample sumMonth() {
        this.sumCol="month";
        return this;
    }

    public StockInfoMonthDiffExample sumStockName() {
        this.sumCol="stock_name";
        return this;
    }

    public StockInfoMonthDiffExample sumDiff() {
        this.sumCol="diff";
        return this;
    }

    public StockInfoMonthDiffExample sumLastMonthDiffOpen() {
        this.sumCol="last_month_diff_open";
        return this;
    }

    public StockInfoMonthDiffExample sumLastMonthDiffHigh() {
        this.sumCol="last_month_diff_high";
        return this;
    }

    public StockInfoMonthDiffExample sumLastMonthDiffLow() {
        this.sumCol="last_month_diff_low";
        return this;
    }

    public StockInfoMonthDiffExample sumLastMonthDiffClose() {
        this.sumCol="last_month_diff_close";
        return this;
    }

    public StockInfoMonthDiffExample sumLastMonthDiffBuyMoney() {
        this.sumCol="last_month_diff_buy_money";
        return this;
    }

    public StockInfoMonthDiffExample sumLastMonthDiffFailMoney() {
        this.sumCol="last_month_diff_fail_money";
        return this;
    }

    public StockInfoMonthDiffExample sumLastMonthDiffNetProfit() {
        this.sumCol="last_month_diff_net_profit";
        return this;
    }

    public StockInfoMonthDiffExample sumLastYearDiffOpen() {
        this.sumCol="last_year_diff_open";
        return this;
    }

    public StockInfoMonthDiffExample sumLastYearDiffHigh() {
        this.sumCol="last_year_diff_high";
        return this;
    }

    public StockInfoMonthDiffExample sumLastYearDiffLow() {
        this.sumCol="last_year_diff_low";
        return this;
    }

    public StockInfoMonthDiffExample sumLastYearDiffClose() {
        this.sumCol="last_year_diff_close";
        return this;
    }

    public StockInfoMonthDiffExample sumLastYearDiffBuyMoney() {
        this.sumCol="last_year_diff_buy_money";
        return this;
    }

    public StockInfoMonthDiffExample sumLastYearDiffFailMoney() {
        this.sumCol="last_year_diff_fail_money";
        return this;
    }

    public StockInfoMonthDiffExample sumLastYearDiffNetProfit() {
        this.sumCol="last_year_diff_net_profit";
        return this;
    }

    public StockInfoMonthDiffExample sumCreateDate() {
        this.sumCol="create_date";
        return this;
    }

    public StockInfoMonthDiffExample sumUpdateDate() {
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

    public StockInfoMonthDiffExample page(int offset, int limit) {
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("month not between", value1, value2, "month");
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

        public Criteria andLastMonthDiffOpenIsNull() {
            addCriterion("last_month_diff_open is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenIsNotNull() {
            addCriterion("last_month_diff_open is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenEqualTo(Float value) {
            addCriterion("last_month_diff_open =", value, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenNotEqualTo(Float value) {
            addCriterion("last_month_diff_open <>", value, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenGreaterThan(Float value) {
            addCriterion("last_month_diff_open >", value, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenGreaterThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_open >=", value, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenLessThan(Float value) {
            addCriterion("last_month_diff_open <", value, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenLessThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_open <=", value, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenIn(List<Float> values) {
            addCriterion("last_month_diff_open in", values, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenNotIn(List<Float> values) {
            addCriterion("last_month_diff_open not in", values, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_open between", value1, value2, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffOpenNotBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_open not between", value1, value2, "lastMonthDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighIsNull() {
            addCriterion("last_month_diff_high is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighIsNotNull() {
            addCriterion("last_month_diff_high is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighEqualTo(Float value) {
            addCriterion("last_month_diff_high =", value, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighNotEqualTo(Float value) {
            addCriterion("last_month_diff_high <>", value, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighGreaterThan(Float value) {
            addCriterion("last_month_diff_high >", value, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighGreaterThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_high >=", value, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighLessThan(Float value) {
            addCriterion("last_month_diff_high <", value, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighLessThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_high <=", value, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighIn(List<Float> values) {
            addCriterion("last_month_diff_high in", values, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighNotIn(List<Float> values) {
            addCriterion("last_month_diff_high not in", values, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_high between", value1, value2, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffHighNotBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_high not between", value1, value2, "lastMonthDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowIsNull() {
            addCriterion("last_month_diff_low is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowIsNotNull() {
            addCriterion("last_month_diff_low is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowEqualTo(Float value) {
            addCriterion("last_month_diff_low =", value, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowNotEqualTo(Float value) {
            addCriterion("last_month_diff_low <>", value, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowGreaterThan(Float value) {
            addCriterion("last_month_diff_low >", value, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowGreaterThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_low >=", value, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowLessThan(Float value) {
            addCriterion("last_month_diff_low <", value, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowLessThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_low <=", value, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowIn(List<Float> values) {
            addCriterion("last_month_diff_low in", values, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowNotIn(List<Float> values) {
            addCriterion("last_month_diff_low not in", values, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_low between", value1, value2, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffLowNotBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_low not between", value1, value2, "lastMonthDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseIsNull() {
            addCriterion("last_month_diff_close is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseIsNotNull() {
            addCriterion("last_month_diff_close is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseEqualTo(Float value) {
            addCriterion("last_month_diff_close =", value, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseNotEqualTo(Float value) {
            addCriterion("last_month_diff_close <>", value, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseGreaterThan(Float value) {
            addCriterion("last_month_diff_close >", value, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseGreaterThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_close >=", value, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseLessThan(Float value) {
            addCriterion("last_month_diff_close <", value, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseLessThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_close <=", value, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseIn(List<Float> values) {
            addCriterion("last_month_diff_close in", values, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseNotIn(List<Float> values) {
            addCriterion("last_month_diff_close not in", values, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_close between", value1, value2, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffCloseNotBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_close not between", value1, value2, "lastMonthDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyIsNull() {
            addCriterion("last_month_diff_buy_money is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyIsNotNull() {
            addCriterion("last_month_diff_buy_money is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyEqualTo(Float value) {
            addCriterion("last_month_diff_buy_money =", value, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyNotEqualTo(Float value) {
            addCriterion("last_month_diff_buy_money <>", value, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyGreaterThan(Float value) {
            addCriterion("last_month_diff_buy_money >", value, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_buy_money >=", value, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyLessThan(Float value) {
            addCriterion("last_month_diff_buy_money <", value, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyLessThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_buy_money <=", value, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyIn(List<Float> values) {
            addCriterion("last_month_diff_buy_money in", values, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyNotIn(List<Float> values) {
            addCriterion("last_month_diff_buy_money not in", values, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_buy_money between", value1, value2, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffBuyMoneyNotBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_buy_money not between", value1, value2, "lastMonthDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyIsNull() {
            addCriterion("last_month_diff_fail_money is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyIsNotNull() {
            addCriterion("last_month_diff_fail_money is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyEqualTo(Float value) {
            addCriterion("last_month_diff_fail_money =", value, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyNotEqualTo(Float value) {
            addCriterion("last_month_diff_fail_money <>", value, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyGreaterThan(Float value) {
            addCriterion("last_month_diff_fail_money >", value, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_fail_money >=", value, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyLessThan(Float value) {
            addCriterion("last_month_diff_fail_money <", value, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyLessThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_fail_money <=", value, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyIn(List<Float> values) {
            addCriterion("last_month_diff_fail_money in", values, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyNotIn(List<Float> values) {
            addCriterion("last_month_diff_fail_money not in", values, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_fail_money between", value1, value2, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffFailMoneyNotBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_fail_money not between", value1, value2, "lastMonthDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitIsNull() {
            addCriterion("last_month_diff_net_profit is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitIsNotNull() {
            addCriterion("last_month_diff_net_profit is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitEqualTo(Float value) {
            addCriterion("last_month_diff_net_profit =", value, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitNotEqualTo(Float value) {
            addCriterion("last_month_diff_net_profit <>", value, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitGreaterThan(Float value) {
            addCriterion("last_month_diff_net_profit >", value, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitGreaterThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_net_profit >=", value, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitLessThan(Float value) {
            addCriterion("last_month_diff_net_profit <", value, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitLessThanOrEqualTo(Float value) {
            addCriterion("last_month_diff_net_profit <=", value, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitIn(List<Float> values) {
            addCriterion("last_month_diff_net_profit in", values, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitNotIn(List<Float> values) {
            addCriterion("last_month_diff_net_profit not in", values, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_net_profit between", value1, value2, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastMonthDiffNetProfitNotBetween(Float value1, Float value2) {
            addCriterion("last_month_diff_net_profit not between", value1, value2, "lastMonthDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenIsNull() {
            addCriterion("last_year_diff_open is null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenIsNotNull() {
            addCriterion("last_year_diff_open is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenEqualTo(Float value) {
            addCriterion("last_year_diff_open =", value, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenNotEqualTo(Float value) {
            addCriterion("last_year_diff_open <>", value, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenGreaterThan(Float value) {
            addCriterion("last_year_diff_open >", value, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenGreaterThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_open >=", value, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenLessThan(Float value) {
            addCriterion("last_year_diff_open <", value, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenLessThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_open <=", value, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenIn(List<Float> values) {
            addCriterion("last_year_diff_open in", values, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenNotIn(List<Float> values) {
            addCriterion("last_year_diff_open not in", values, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_open between", value1, value2, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffOpenNotBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_open not between", value1, value2, "lastYearDiffOpen");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighIsNull() {
            addCriterion("last_year_diff_high is null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighIsNotNull() {
            addCriterion("last_year_diff_high is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighEqualTo(Float value) {
            addCriterion("last_year_diff_high =", value, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighNotEqualTo(Float value) {
            addCriterion("last_year_diff_high <>", value, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighGreaterThan(Float value) {
            addCriterion("last_year_diff_high >", value, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighGreaterThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_high >=", value, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighLessThan(Float value) {
            addCriterion("last_year_diff_high <", value, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighLessThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_high <=", value, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighIn(List<Float> values) {
            addCriterion("last_year_diff_high in", values, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighNotIn(List<Float> values) {
            addCriterion("last_year_diff_high not in", values, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_high between", value1, value2, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffHighNotBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_high not between", value1, value2, "lastYearDiffHigh");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowIsNull() {
            addCriterion("last_year_diff_low is null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowIsNotNull() {
            addCriterion("last_year_diff_low is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowEqualTo(Float value) {
            addCriterion("last_year_diff_low =", value, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowNotEqualTo(Float value) {
            addCriterion("last_year_diff_low <>", value, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowGreaterThan(Float value) {
            addCriterion("last_year_diff_low >", value, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowGreaterThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_low >=", value, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowLessThan(Float value) {
            addCriterion("last_year_diff_low <", value, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowLessThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_low <=", value, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowIn(List<Float> values) {
            addCriterion("last_year_diff_low in", values, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowNotIn(List<Float> values) {
            addCriterion("last_year_diff_low not in", values, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_low between", value1, value2, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffLowNotBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_low not between", value1, value2, "lastYearDiffLow");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseIsNull() {
            addCriterion("last_year_diff_close is null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseIsNotNull() {
            addCriterion("last_year_diff_close is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseEqualTo(Float value) {
            addCriterion("last_year_diff_close =", value, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseNotEqualTo(Float value) {
            addCriterion("last_year_diff_close <>", value, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseGreaterThan(Float value) {
            addCriterion("last_year_diff_close >", value, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseGreaterThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_close >=", value, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseLessThan(Float value) {
            addCriterion("last_year_diff_close <", value, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseLessThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_close <=", value, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseIn(List<Float> values) {
            addCriterion("last_year_diff_close in", values, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseNotIn(List<Float> values) {
            addCriterion("last_year_diff_close not in", values, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_close between", value1, value2, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffCloseNotBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_close not between", value1, value2, "lastYearDiffClose");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyIsNull() {
            addCriterion("last_year_diff_buy_money is null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyIsNotNull() {
            addCriterion("last_year_diff_buy_money is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyEqualTo(Float value) {
            addCriterion("last_year_diff_buy_money =", value, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyNotEqualTo(Float value) {
            addCriterion("last_year_diff_buy_money <>", value, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyGreaterThan(Float value) {
            addCriterion("last_year_diff_buy_money >", value, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_buy_money >=", value, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyLessThan(Float value) {
            addCriterion("last_year_diff_buy_money <", value, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyLessThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_buy_money <=", value, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyIn(List<Float> values) {
            addCriterion("last_year_diff_buy_money in", values, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyNotIn(List<Float> values) {
            addCriterion("last_year_diff_buy_money not in", values, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_buy_money between", value1, value2, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffBuyMoneyNotBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_buy_money not between", value1, value2, "lastYearDiffBuyMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyIsNull() {
            addCriterion("last_year_diff_fail_money is null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyIsNotNull() {
            addCriterion("last_year_diff_fail_money is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyEqualTo(Float value) {
            addCriterion("last_year_diff_fail_money =", value, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyNotEqualTo(Float value) {
            addCriterion("last_year_diff_fail_money <>", value, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyGreaterThan(Float value) {
            addCriterion("last_year_diff_fail_money >", value, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_fail_money >=", value, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyLessThan(Float value) {
            addCriterion("last_year_diff_fail_money <", value, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyLessThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_fail_money <=", value, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyIn(List<Float> values) {
            addCriterion("last_year_diff_fail_money in", values, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyNotIn(List<Float> values) {
            addCriterion("last_year_diff_fail_money not in", values, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_fail_money between", value1, value2, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffFailMoneyNotBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_fail_money not between", value1, value2, "lastYearDiffFailMoney");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitIsNull() {
            addCriterion("last_year_diff_net_profit is null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitIsNotNull() {
            addCriterion("last_year_diff_net_profit is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitEqualTo(Float value) {
            addCriterion("last_year_diff_net_profit =", value, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitNotEqualTo(Float value) {
            addCriterion("last_year_diff_net_profit <>", value, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitGreaterThan(Float value) {
            addCriterion("last_year_diff_net_profit >", value, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitGreaterThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_net_profit >=", value, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitLessThan(Float value) {
            addCriterion("last_year_diff_net_profit <", value, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitLessThanOrEqualTo(Float value) {
            addCriterion("last_year_diff_net_profit <=", value, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitIn(List<Float> values) {
            addCriterion("last_year_diff_net_profit in", values, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitNotIn(List<Float> values) {
            addCriterion("last_year_diff_net_profit not in", values, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_net_profit between", value1, value2, "lastYearDiffNetProfit");
            return (Criteria) this;
        }

        public Criteria andLastYearDiffNetProfitNotBetween(Float value1, Float value2) {
            addCriterion("last_year_diff_net_profit not between", value1, value2, "lastYearDiffNetProfit");
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