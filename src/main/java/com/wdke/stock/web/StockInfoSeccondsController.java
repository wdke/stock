package com.wdke.stock.web;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoSeccondsService;
import com.wdke.stock.web.vo.StockEchartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 每秒数据的统计
 *
 * @Author: wdke
 * @Date: 2020-11-20 09:53
 * @Version: 1.0
 */
@RequestMapping("stock/info/secconds")
@RestController
public class StockInfoSeccondsController {



    @Autowired
    private StockInfoSeccondsService stockInfoSeccondsService;


    /**
     * 单只股票
     * @param type
     * @param stockCode
     * @return
     */
    @RequestMapping(value = "echart/{type}/{stockCode}")
    public ResponseVo<StockEchartVo> comparingThreeDays(@PathVariable Integer type, @PathVariable String stockCode) {
        ResponseVo<StockEchartVo> result = stockInfoSeccondsService.comparingThreeDays(type, stockCode);
        return result;
    }


    /**
     * 持仓数据的股票
     *
     * @return
     */
    @RequestMapping(value = "echart/hold")
    public ResponseVo<List<StockEchartVo>> comparingThreeDaysHole() {
        ResponseVo<List<StockEchartVo>> result = stockInfoSeccondsService.comparingThreeDaysHole();
        return result;
    }
}
