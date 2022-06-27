package com.wdke.stock.web;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockService;
import com.wdke.stock.web.vo.StockEchartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-11-17 14:54
 * @Version: 1.0
 */
@RestController
@RequestMapping("stock")
public class StockController {


    @Autowired
    private StockService stockService;

    /**
     * 单只股票
     * @param type
     * @param stockCode
     * @return
     */
    @RequestMapping(value = "echart/{type}/{stockCode}")
    public ResponseVo<StockEchartVo> echartData(@PathVariable Integer type, @PathVariable String stockCode) {
        ResponseVo<StockEchartVo> result = stockService.todayPriceVolume(type, stockCode);
        return result;
    }


    /**
     * 持仓数据的股票
     *
     * @return
     */
    @RequestMapping(value = "echart/hold")
    public ResponseVo<List<StockEchartVo>> todayHoldPriceVolume() {
        ResponseVo<List<StockEchartVo>> result = stockService.todayHoldPriceVolume();
        return result;
    }
}
