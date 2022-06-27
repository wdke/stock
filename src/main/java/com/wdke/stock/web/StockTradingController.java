package com.wdke.stock.web;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoHeldService;
import com.wdke.stock.service.StockTradingService;
import com.wdke.stock.storage.entity.StockInfoHeld;
import com.wdke.stock.storage.entity.StockTrading;
import com.wdke.stock.web.args.StockTradingAddArgs;
import com.wdke.stock.web.vo.StockInfoEarningVo;
import com.wdke.stock.web.vo.StockInfoHeldEndVo;
import com.wdke.stock.web.vo.StockInfoHeldVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 股票交易接口
 *
 * @Author: wdke
 * @Date: 2020-10-23 14:04
 * @Version: 1.0
 */

@RestController
@RequestMapping("stock/trading")
public class StockTradingController {


    @Autowired
    private StockTradingService stockTradingService;


    @Autowired
    private StockInfoHeldService stockInfoHeldService;


    /**
     * 新增交易数据
     *
     * @param stockTradingAddArgs
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseVo<Integer> add(@RequestBody @Valid StockTradingAddArgs stockTradingAddArgs) {


        ResponseVo<Integer> result = stockInfoHeldService.add(stockTradingAddArgs);

        return result;
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public ResponseVo<Integer> delete(@PathVariable Integer id) {

        ResponseVo<Integer> result = stockInfoHeldService.delete(id);

        return result;
    }


    @RequestMapping(value = "undo/{id}", method = RequestMethod.GET)
    public ResponseVo<Integer> undo(@PathVariable Integer id) {

        ResponseVo<Integer> result = stockTradingService.undo(id);

        return result;
    }

    @RequestMapping(value = "complete/{id}", method = RequestMethod.GET)
    public ResponseVo<Integer> end(@PathVariable Integer id) {

        ResponseVo<Integer> result = stockTradingService.complete(id);

        return result;
    }

    /**
     * 合并多次交易
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "merge", method = RequestMethod.GET)
    public ResponseVo<Integer> merge(@RequestParam("ids") List<Integer> ids) {

        ResponseVo<Integer> result = stockInfoHeldService.merge(ids);

        return result;
    }

    /**
     * 进行结束
     *
     * @param id
     * @param price
     * @return
     */
    @RequestMapping(value = "toEnd/{id}", method = RequestMethod.GET)
    public ResponseVo<Integer> toEnd(@PathVariable Integer id, @RequestParam("price") Float price) {

        ResponseVo<Integer> result = stockInfoHeldService.toEnd(id, price);

        return result;
    }

    /**
     * 获取所有列表
     *
     * @return
     */
    @RequestMapping(value = "list")
    public ResponseVo<List<StockTrading>> list() {


        ResponseVo<List<StockTrading>> result = stockTradingService.list();

        return result;
    }


    /**
     * 获取所有列表
     *
     * @return
     */
    @RequestMapping(value = "held/list")
    public ResponseVo<List<StockInfoHeldVo>> holdList() {


        ResponseVo<List<StockInfoHeldVo>> result = stockInfoHeldService.list();

        return result;
    }


    /**
     * 获取每只股票收益列表
     *
     * @return
     */
    @RequestMapping(value = "held/list/end")
    public ResponseVo<List<StockInfoHeldEndVo>> holdListEnd() {


        ResponseVo<List<StockInfoHeldEndVo>> result = stockInfoHeldService.listEnd();

        return result;
    }

    /**
     * 获取总收益列表
     *
     * @return
     */
    @RequestMapping(value = "held/day/earning")
    public ResponseVo<List<StockInfoEarningVo>> holddayEaring() {


        ResponseVo<List<StockInfoEarningVo>> result = stockInfoHeldService.holddayEaring();

        return result;
    }

    /**
     * 获取所有列表
     *
     * @return
     */
    @RequestMapping(value = "held/list/{stockType}/{stockCode}")
    public ResponseVo<List<StockInfoHeld>> holdList(@PathVariable("stockType") Integer stockType, @PathVariable("stockCode") String stockCode) {


        ResponseVo<List<StockInfoHeld>> result = stockInfoHeldService.list(stockType, stockCode);

        return result;
    }
}
