package com.wdke.stock.web;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoDayService;
import com.wdke.stock.web.vo.StockEchartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-11-17 16:29
 * @Version: 1.0
 */
@RestController
@RequestMapping("stock/info/day")
public class StockInfoDayController {


    @Autowired
    private StockInfoDayService stockInfoDayService;

    /**
     * 单只股票
     * @param type
     * @param stockCode
     * @return
     */
    @RequestMapping(value = "echart/{type}/{stockCode}")
    public ResponseVo<StockEchartVo> buySellCont(@PathVariable Integer type, @PathVariable String stockCode) {
        ResponseVo<StockEchartVo> result = stockInfoDayService.buySellCont(type, stockCode);
        return result;
    }


    /**
     * 持仓数据的股票
     *
     * @return
     */
    @RequestMapping(value = "echart/hold")
    public ResponseVo<List<StockEchartVo>> buySellContHole() {
        ResponseVo<List<StockEchartVo>> result = stockInfoDayService.buySellContHole();
        return result;
    }
}
