package com.wdke.stock.web.handle;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.task.StockSnalysisAsynHandle;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("handle/snalysis")
public class HandleSnalysisController {

    @Autowired
    private StockSnalysisAsynHandle stockSnalysisAsynHandle;

    /**
     * 计算
     *
     * @return
     */
    @RequestMapping(value = "held/calculate")
    public ResponseVo<String> calculateHeldToday() {
        stockSnalysisAsynHandle.calculateHeldToday();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }
    /**
     * 计算
     *
     * @return
     */
    @RequestMapping(value = "calculate")
    public ResponseVo<String> calculateToday() {
        stockSnalysisAsynHandle.calculateToday();
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }


}
