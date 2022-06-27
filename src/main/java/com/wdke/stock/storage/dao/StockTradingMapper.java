package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockTrading;
import com.wdke.stock.storage.entity.StockTradingExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockTradingMapper {
    long countByExample(StockTradingExample example);

    int deleteByExample(StockTradingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockTrading record);

    int insertSelective(StockTrading record);

    List<StockTrading> selectByExampleWithRowbounds(StockTradingExample example, RowBounds rowBounds);

    List<StockTrading> selectByExample(StockTradingExample example);

    StockTrading selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockTrading record, @Param("example") StockTradingExample example);

    int updateByExample(@Param("record") StockTrading record, @Param("example") StockTradingExample example);

    int updateByPrimaryKeySelective(StockTrading record);

    int updateByPrimaryKey(StockTrading record);

    Long sumByExample(StockTradingExample example);

    void batchInsert(@Param("items") List<StockTrading> items);
}