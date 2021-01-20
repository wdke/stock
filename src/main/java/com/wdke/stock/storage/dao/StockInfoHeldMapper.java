package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockInfoHeld;
import com.wdke.stock.storage.entity.StockInfoHeldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StockInfoHeldMapper {
    long countByExample(StockInfoHeldExample example);

    int deleteByExample(StockInfoHeldExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockInfoHeld record);

    int insertSelective(StockInfoHeld record);

    List<StockInfoHeld> selectByExampleWithRowbounds(StockInfoHeldExample example, RowBounds rowBounds);

    List<StockInfoHeld> selectByExample(StockInfoHeldExample example);

    StockInfoHeld selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockInfoHeld record, @Param("example") StockInfoHeldExample example);

    int updateByExample(@Param("record") StockInfoHeld record, @Param("example") StockInfoHeldExample example);

    int updateByPrimaryKeySelective(StockInfoHeld record);

    int updateByPrimaryKey(StockInfoHeld record);

    Long sumByExample(StockInfoHeldExample example);

    void batchInsert(@Param("items") List<StockInfoHeld> items);
}