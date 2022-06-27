package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockInfoMonth;
import com.wdke.stock.storage.entity.StockInfoMonthExample;
import com.wdke.stock.storage.entity.StockInfoMonthKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInfoMonthMapper {
    long countByExample(StockInfoMonthExample example);

    int deleteByExample(StockInfoMonthExample example);

    int deleteByPrimaryKey(StockInfoMonthKey key);

    int insert(StockInfoMonth record);

    int insertSelective(StockInfoMonth record);

    List<StockInfoMonth> selectByExampleWithRowbounds(StockInfoMonthExample example, RowBounds rowBounds);

    List<StockInfoMonth> selectByExample(StockInfoMonthExample example);

    StockInfoMonth selectByPrimaryKey(StockInfoMonthKey key);

    int updateByExampleSelective(@Param("record") StockInfoMonth record, @Param("example") StockInfoMonthExample example);

    int updateByExample(@Param("record") StockInfoMonth record, @Param("example") StockInfoMonthExample example);

    int updateByPrimaryKeySelective(StockInfoMonth record);

    int updateByPrimaryKey(StockInfoMonth record);

    Long sumByExample(StockInfoMonthExample example);

    void batchInsert(@Param("items") List<StockInfoMonth> items);
}