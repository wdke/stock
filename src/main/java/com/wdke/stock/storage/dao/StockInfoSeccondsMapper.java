package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockInfoSecconds;
import com.wdke.stock.storage.entity.StockInfoSeccondsExample;
import com.wdke.stock.storage.entity.StockInfoSeccondsKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInfoSeccondsMapper {
    long countByExample(StockInfoSeccondsExample example);

    int deleteByExample(StockInfoSeccondsExample example);

    int deleteByPrimaryKey(StockInfoSeccondsKey key);

    int insert(StockInfoSecconds record);

    int insertSelective(StockInfoSecconds record);

    List<StockInfoSecconds> selectByExampleWithRowbounds(StockInfoSeccondsExample example, RowBounds rowBounds);

    List<StockInfoSecconds> selectByExample(StockInfoSeccondsExample example);

    StockInfoSecconds selectByPrimaryKey(StockInfoSeccondsKey key);

    int updateByExampleSelective(@Param("record") StockInfoSecconds record, @Param("example") StockInfoSeccondsExample example);

    int updateByExample(@Param("record") StockInfoSecconds record, @Param("example") StockInfoSeccondsExample example);

    int updateByPrimaryKeySelective(StockInfoSecconds record);

    int updateByPrimaryKey(StockInfoSecconds record);

    Long sumByExample(StockInfoSeccondsExample example);

    void batchInsert(@Param("items") List<StockInfoSecconds> items);
}