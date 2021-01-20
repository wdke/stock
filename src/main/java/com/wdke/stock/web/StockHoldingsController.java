package com.wdke.stock.web;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockHoldingsService;
import com.wdke.stock.web.vo.StockCurrentHoldPriceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股票持仓
 *
 * @Author: wdke
 * @Date: 2020-10-23 16:16
 * @Version: 1.0
 */
@RestController
@RequestMapping("stock/holdings")
public class StockHoldingsController {
    @Autowired
    private StockHoldingsService stockHoldingsService;



    /**
     * 获取所有列表
     *
     * @return
     */
    @RequestMapping(value = "list")
    public ResponseVo<List<StockCurrentHoldPriceVo>> list() {


        ResponseVo<List<StockCurrentHoldPriceVo>> result = stockHoldingsService.list();

        return result;
    }


    /**
     * 获取所有列表
     *
     * @return
     */
    @RequestMapping(value = "detail/{id}")
    public ResponseVo<Map<String, Object>> detail(@PathVariable Integer id) {


        Map<String, Object> map = new HashMap<>();
        ResponseVo<StockCurrentHoldPriceVo> result = stockHoldingsService.detail(id);
        if (null != result.getData()) {
//            int type=0;
//            if(result.getData().getStockCode().startsWith("sz")){
//                type=1;
//            }
//
//            StockEchartVo data = stockService.echartbarData(type,result.getData().getStockCode().substring(2)).getData();
//            if (null == data) {
//                data = new StockEchartVo();
//                data.setKey(new ArrayList<>(1));
//                data.setValue(new ArrayList<>(1));
//            }
//            data.setStockCode(result.getData().getStockCode());
//            data.setTitle(result.getData().getStockName());
//            data.setStockName(data.getTitle());
//
//            StockEchartVo priceEchartList = stockService.todayPriceEchartList(type,result.getData().getStockCode().substring(2)).getData();
//            if (null == priceEchartList) {
//
//                priceEchartList = new StockEchartVo();
//                priceEchartList.setKey(new ArrayList<>(1));
//                priceEchartList.setValue(new ArrayList<>(1));
//            }
//
//            priceEchartList.setTitle(result.getData().getStockName());;
//            priceEchartList.setStockCode(result.getData().getStockCode());
//            priceEchartList.setStockName(data.getTitle());
//
//            map.put("detail", result.getData());
//            map.put("eChartData", data);
//            map.put("eChartLineData", priceEchartList);
        }

        return new ResponseVo<>(result.getCode(), result.getMsg(), map);
    }




    /**
     * 关注
     * @param type
     * @param stockCode
     * @return
     */
    @RequestMapping(value = "focus/{type}/{stockCode}")
    public ResponseVo<Integer> focus(@PathVariable Integer type, @PathVariable String stockCode) {
        ResponseVo<Integer> result = stockHoldingsService.focus(type, stockCode);
        return result;
    }
}
