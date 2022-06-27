package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockInfoMonthDiff;
import com.wdke.stock.storage.entity.StockInfoMonthDiffExample;
import com.wdke.stock.storage.entity.StockInfoMonthDiffKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInfoMonthDiffMapper {
    long countByExample(StockInfoMonthDiffExample example);

    int deleteByExample(StockInfoMonthDiffExample example);

    int deleteByPrimaryKey(StockInfoMonthDiffKey key);

    int insert(StockInfoMonthDiff record);

    int insertSelective(StockInfoMonthDiff record);

    List<StockInfoMonthDiff> selectByExampleWithRowbounds(StockInfoMonthDiffExample example, RowBounds rowBounds);

    List<StockInfoMonthDiff> selectByExample(StockInfoMonthDiffExample example);

    StockInfoMonthDiff selectByPrimaryKey(StockInfoMonthDiffKey key);

    int updateByExampleSelective(@Param("record") StockInfoMonthDiff record, @Param("example") StockInfoMonthDiffExample example);

    int updateByExample(@Param("record") StockInfoMonthDiff record, @Param("example") StockInfoMonthDiffExample example);

    int updateByPrimaryKeySelective(StockInfoMonthDiff record);

    int updateByPrimaryKey(StockInfoMonthDiff record);

    Long sumByExample(StockInfoMonthDiffExample example);

    void batchInsert(@Param("items") List<StockInfoMonthDiff> items);
}