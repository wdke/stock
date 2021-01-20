package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockHoldings;
import com.wdke.stock.storage.entity.StockHoldingsExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockHoldingsMapper {
    long countByExample(StockHoldingsExample example);

    int deleteByExample(StockHoldingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockHoldings record);

    int insertSelective(StockHoldings record);

    List<StockHoldings> selectByExampleWithRowbounds(StockHoldingsExample example, RowBounds rowBounds);

    List<StockHoldings> selectByExample(StockHoldingsExample example);

    StockHoldings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockHoldings record, @Param("example") StockHoldingsExample example);

    int updateByExample(@Param("record") StockHoldings record, @Param("example") StockHoldingsExample example);

    int updateByPrimaryKeySelective(StockHoldings record);

    int updateByPrimaryKey(StockHoldings record);

    Long sumByExample(StockHoldingsExample example);

    void batchInsert(@Param("items") List<StockHoldings> items);
}