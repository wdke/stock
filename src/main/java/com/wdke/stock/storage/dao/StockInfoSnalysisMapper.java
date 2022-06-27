package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockInfoSnalysis;
import com.wdke.stock.storage.entity.StockInfoSnalysisExample;
import com.wdke.stock.storage.entity.StockInfoSnalysisKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInfoSnalysisMapper {
    long countByExample(StockInfoSnalysisExample example);

    int deleteByExample(StockInfoSnalysisExample example);

    int deleteByPrimaryKey(StockInfoSnalysisKey key);

    int insert(StockInfoSnalysis record);

    int insertSelective(StockInfoSnalysis record);

    List<StockInfoSnalysis> selectByExampleWithRowbounds(StockInfoSnalysisExample example, RowBounds rowBounds);

    List<StockInfoSnalysis> selectByExample(StockInfoSnalysisExample example);

    StockInfoSnalysis selectByPrimaryKey(StockInfoSnalysisKey key);

    int updateByExampleSelective(@Param("record") StockInfoSnalysis record, @Param("example") StockInfoSnalysisExample example);

    int updateByExample(@Param("record") StockInfoSnalysis record, @Param("example") StockInfoSnalysisExample example);

    int updateByPrimaryKeySelective(StockInfoSnalysis record);

    int updateByPrimaryKey(StockInfoSnalysis record);

    Long sumByExample(StockInfoSnalysisExample example);

    void batchInsert(@Param("items") List<StockInfoSnalysis> items);
}