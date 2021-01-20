package com.wdke.stock.web;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoDayService;
import com.wdke.stock.task.StockAsynHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 批处理接口
 *
 * @Author: wdke
 * @Date: 2020-11-03 12:19
 * @Version: 1.0
 */
@RestController
@RequestMapping("handle")
public class HandleController {

    @Autowired
    private StockAsynHandle stockAsynHandle;

    @Autowired
    private StockInfoDayService stockInfoDayService;


    /**
     * 计算全年数据
     *
     * @return
     */
    @RequestMapping(value = "/calculate/year")
    public ResponseVo<String> calculateTodayYear() {
        stockAsynHandle.handleYearAll();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 计算每月数据
     *
     * @return
     */
    @RequestMapping(value = "/diff/month")
    public ResponseVo<String> diffMonth() {
        stockAsynHandle.handleMonthDiff();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }
    /**
     * 计算每月数据
     *
     * @return
     */
    @RequestMapping(value = "/calculate/month")
    public ResponseVo<String> calculateMonth() {
        stockAsynHandle.handleMonthAll();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 处理当日数据
     *
     * @return
     */
    @RequestMapping(value = "/day/today")
    public ResponseVo<String> handleDayToday() {
        stockAsynHandle.handleStockInfoDayToday();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 处理每天每秒的数据
     *
     * @return
     */
    @RequestMapping(value = "/secconds/today")
    public ResponseVo<String> handleSeccondsToday() {
        stockAsynHandle.handleSeccondsToday();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 按照年份处理
     *
     * @param type
     * @return
     */
    @RequestMapping(value = "/{stockCode}/{type}")
    public ResponseVo<String> handleYear(@PathVariable String stockCode, @PathVariable Integer type) {
        stockInfoDayService.handle(type, 2020, stockCode);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    @RequestMapping(value = "{year}")
    public ResponseVo<String> handleYear(@PathVariable Integer year) {
        stockAsynHandle.handleDayByYear(year);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 计算
     *
     * @return
     */
    @RequestMapping(value = "calculate")
    public ResponseVo<String> calculateToday() {
        stockAsynHandle.calculateToday();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 计算
     *
     * @return
     */
    @RequestMapping(value = "buySell")
    public ResponseVo<String> buySell() {
        stockAsynHandle.buySellTimeAll();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

}
