package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.StockInfoYear;
import com.wdke.stock.storage.entity.StockInfoYearExample;
import com.wdke.stock.storage.entity.StockInfoYearKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInfoYearMapper {
    long countByExample(StockInfoYearExample example);

    int deleteByExample(StockInfoYearExample example);

    int deleteByPrimaryKey(StockInfoYearKey key);

    int insert(StockInfoYear record);

    int insertSelective(StockInfoYear record);

    List<StockInfoYear> selectByExampleWithRowbounds(StockInfoYearExample example, RowBounds rowBounds);

    List<StockInfoYear> selectByExample(StockInfoYearExample example);

    StockInfoYear selectByPrimaryKey(StockInfoYearKey key);

    int updateByExampleSelective(@Param("record") StockInfoYear record, @Param("example") StockInfoYearExample example);

    int updateByExample(@Param("record") StockInfoYear record, @Param("example") StockInfoYearExample example);

    int updateByPrimaryKeySelective(StockInfoYear record);

    int updateByPrimaryKey(StockInfoYear record);

    Long sumByExample(StockInfoYearExample example);

    void batchInsert(@Param("items") List<StockInfoYear> items);
}