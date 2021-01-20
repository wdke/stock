package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockInfoDay;
import com.wdke.stock.storage.entity.StockInfoDayExample;
import com.wdke.stock.storage.entity.StockInfoDayKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInfoDayMapper {
    long countByExample(StockInfoDayExample example);

    int deleteByExample(StockInfoDayExample example);

    int deleteByPrimaryKey(StockInfoDayKey key);

    int insert(StockInfoDay record);

    int insertSelective(StockInfoDay record);

    List<StockInfoDay> selectByExampleWithRowbounds(StockInfoDayExample example, RowBounds rowBounds);

    List<StockInfoDay> selectByExample(StockInfoDayExample example);

    StockInfoDay selectByPrimaryKey(StockInfoDayKey key);

    int updateByExampleSelective(@Param("record") StockInfoDay record, @Param("example") StockInfoDayExample example);

    int updateByExample(@Param("record") StockInfoDay record, @Param("example") StockInfoDayExample example);

    int updateByPrimaryKeySelective(StockInfoDay record);

    int updateByPrimaryKey(StockInfoDay record);

    Long sumByExample(StockInfoDayExample example);

    void batchInsert(@Param("items") List<StockInfoDay> items);
}