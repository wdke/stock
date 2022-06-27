package com.wdke.stock.web;

import com.github.pagehelper.PageInfo;
import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.PageParam;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoMonthDiffService;
import com.wdke.stock.service.StockInfoMonthService;
import com.wdke.stock.service.StockInfoSnalysisService;
import com.wdke.stock.storage.entity.StockInfoSnalysis;
import com.wdke.stock.web.args.StockInfoMonthArgs;
import com.wdke.stock.web.args.StockInfoSnalysisArgs;
import com.wdke.stock.web.vo.StockEchartVo;
import com.wdke.stock.web.vo.StockInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 测试
 *
 * @Author: wdke
 * @Date: 2020-10-16 17:21
 * @Version: 1.0
 */
@RestController
@RequestMapping("stock/info")
public class StockInfoController {

    private static Logger logger = LoggerFactory.getLogger(StockInfoController.class);


    @Autowired
    private StockInfoSnalysisService stockInfoSnalysisService;


    @Autowired
    private StockInfoMonthService stockInfoMonthService;

    @Autowired
    private StockInfoMonthDiffService stockInfoMonthDiffService;

    /**
     * 股票代代码列表
     *
     * @return
     */
    @RequestMapping(value = "/snalysis/list", method = RequestMethod.POST)
    public ResponseVo<PageInfo<StockInfoSnalysis>> stockInfoList(@RequestBody @Valid StockInfoSnalysisArgs args) {

        PageInfo<StockInfoSnalysis> list = stockInfoSnalysisService.list(args);

        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, list);
    }


    /**
     * 每月股票统计
     *
     * @return
     */
    @RequestMapping(value = "/month/list/echart", method = RequestMethod.GET)
    public ResponseVo<StockEchartVo> monthListEchart(StockInfoMonthArgs args, PageParam pageParam) {

        ResponseVo<StockEchartVo> result = stockInfoMonthService.monthListEchart(args,pageParam);

        return result;
    }


    /**
     * 每月股票统计
     *
     * @return
     */
    @RequestMapping(value = "/diff/list/echart", method = RequestMethod.GET)
    public ResponseVo<List<StockEchartVo>> diffListEchart(StockInfoMonthArgs args) {

        ResponseVo<List<StockEchartVo>> result = stockInfoMonthDiffService.monthListEchart(args);

        return result;
    }
    /**
     * 查找列表
     *
     * @return
     */
    @RequestMapping(value = "search/{words}")
    public ResponseVo<List<StockInfoVo>> searchStockInfoList(@PathVariable String words) {
        return stockInfoSnalysisService.searchStockInfoList(words);
    }


}
