package com.wdke.stock.web.handle;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.task.StockDayAsynHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理天数据
 *
 * @Author: wdke
 * @Date: 2/3/21 2:40 PM
 * @Version: 1.0
 */
@RestController
@RequestMapping("handle/day")
public class HandleDayController {

    @Autowired
    private StockDayAsynHandle stockDayAsynHandle;


    /**
     * 处理当日数据
     *
     * @return
     */
    @RequestMapping(value = "/today")
    public ResponseVo<String> handleDayToday() {
        stockDayAsynHandle.handleToday();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    @RequestMapping(value = "{year}")
    public ResponseVo<String> handleYear(@PathVariable Integer year) {
        stockDayAsynHandle.handleByYear(year);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }


    /**
     * 计算
     *
     * @return
     */
    @RequestMapping(value = "buySell")
    public ResponseVo<String> buySell() {
        stockDayAsynHandle.buySellTimeAll();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }
}
