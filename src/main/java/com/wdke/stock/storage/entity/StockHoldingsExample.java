package com.wdke.stock.storage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockHoldingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public StockHoldingsExample() {
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

    public StockHoldingsExample sumId() {
        this.sumCol="id";
        return this;
    }

    public StockHoldingsExample sumStockCode() {
        this.sumCol="stock_code";
        return this;
    }

    public StockHoldingsExample sumStockType() {
        this.sumCol="stock_type";
        return this;
    }

    public StockHoldingsExample sumStockName() {
        this.sumCol="stock_name";
        return this;
    }

    public StockHoldingsExample sumBuyMoney() {
        this.sumCol="buy_money";
        return this;
    }

    public StockHoldingsExample sumSellMoney() {
        this.sumCol="sell_money";
        return this;
    }

    public StockHoldingsExample sumHoldNumber() {
        this.sumCol="hold_number";
        return this;
    }

    public StockHoldingsExample sumBasePrice() {
        this.sumCol="base_price";
        return this;
    }

    public StockHoldingsExample sumUserId() {
        this.sumCol="user_id";
        return this;
    }

    public StockHoldingsExample sumCreateDate() {
        this.sumCol="create_date";
        return this;
    }

    public StockHoldingsExample sumUpdateDate() {
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

    public StockHoldingsExample page(int offset, int limit) {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andBuyMoneyIsNull() {
            addCriterion("buy_money is null");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyIsNotNull() {
            addCriterion("buy_money is not null");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyEqualTo(Float value) {
            addCriterion("buy_money =", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotEqualTo(Float value) {
            addCriterion("buy_money <>", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyGreaterThan(Float value) {
            addCriterion("buy_money >", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("buy_money >=", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyLessThan(Float value) {
            addCriterion("buy_money <", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyLessThanOrEqualTo(Float value) {
            addCriterion("buy_money <=", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyIn(List<Float> values) {
            addCriterion("buy_money in", values, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotIn(List<Float> values) {
            addCriterion("buy_money not in", values, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyBetween(Float value1, Float value2) {
            addCriterion("buy_money between", value1, value2, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotBetween(Float value1, Float value2) {
            addCriterion("buy_money not between", value1, value2, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyIsNull() {
            addCriterion("sell_money is null");
            return (Criteria) this;
        }

        public Criteria andSellMoneyIsNotNull() {
            addCriterion("sell_money is not null");
            return (Criteria) this;
        }

        public Criteria andSellMoneyEqualTo(Float value) {
            addCriterion("sell_money =", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyNotEqualTo(Float value) {
            addCriterion("sell_money <>", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyGreaterThan(Float value) {
            addCriterion("sell_money >", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("sell_money >=", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyLessThan(Float value) {
            addCriterion("sell_money <", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyLessThanOrEqualTo(Float value) {
            addCriterion("sell_money <=", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyIn(List<Float> values) {
            addCriterion("sell_money in", values, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyNotIn(List<Float> values) {
            addCriterion("sell_money not in", values, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyBetween(Float value1, Float value2) {
            addCriterion("sell_money between", value1, value2, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyNotBetween(Float value1, Float value2) {
            addCriterion("sell_money not between", value1, value2, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andHoldNumberIsNull() {
            addCriterion("hold_number is null");
            return (Criteria) this;
        }

        public Criteria andHoldNumberIsNotNull() {
            addCriterion("hold_number is not null");
            return (Criteria) this;
        }

        public Criteria andHoldNumberEqualTo(Integer value) {
            addCriterion("hold_number =", value, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberNotEqualTo(Integer value) {
            addCriterion("hold_number <>", value, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberGreaterThan(Integer value) {
            addCriterion("hold_number >", value, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("hold_number >=", value, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberLessThan(Integer value) {
            addCriterion("hold_number <", value, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberLessThanOrEqualTo(Integer value) {
            addCriterion("hold_number <=", value, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberIn(List<Integer> values) {
            addCriterion("hold_number in", values, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberNotIn(List<Integer> values) {
            addCriterion("hold_number not in", values, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberBetween(Integer value1, Integer value2) {
            addCriterion("hold_number between", value1, value2, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andHoldNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("hold_number not between", value1, value2, "holdNumber");
            return (Criteria) this;
        }

        public Criteria andBasePriceIsNull() {
            addCriterion("base_price is null");
            return (Criteria) this;
        }

        public Criteria andBasePriceIsNotNull() {
            addCriterion("base_price is not null");
            return (Criteria) this;
        }

        public Criteria andBasePriceEqualTo(Float value) {
            addCriterion("base_price =", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotEqualTo(Float value) {
            addCriterion("base_price <>", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceGreaterThan(Float value) {
            addCriterion("base_price >", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("base_price >=", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceLessThan(Float value) {
            addCriterion("base_price <", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceLessThanOrEqualTo(Float value) {
            addCriterion("base_price <=", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceIn(List<Float> values) {
            addCriterion("base_price in", values, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotIn(List<Float> values) {
            addCriterion("base_price not in", values, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceBetween(Float value1, Float value2) {
            addCriterion("base_price between", value1, value2, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotBetween(Float value1, Float value2) {
            addCriterion("base_price not between", value1, value2, "basePrice");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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