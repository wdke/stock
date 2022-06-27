package com.wdke.stock.https;

import com.wdke.stock.utils.JavaTypeUtils;
import com.wdke.stock.utils.OkHttpUtils;
import com.wdke.stock.web.vo.StockSeccodsPriceVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 新浪股票信息调用
 *
 * @Author: wdke
 * @Date: 2020-10-16 17:11
 * @Version: 1.0
 */
@Service
public class SinaStockApi {

    private static Logger logger = LoggerFactory.getLogger(SinaStockApi.class);


    @Autowired
    private ValueOperations<String, String> valueOperations;

    @Autowired
    private HashOperations<String, String, String> hashOperations;


    private SimpleDateFormat sdfH = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 获取当前的股票行情
     * JSON实时数据，以逗号隔开相关数据，数据依次是“股票名称、今日开盘价、昨日收盘价、当前价格、今日最高价、今日最低价、竞买价、竞卖价、成交股数、成交金额、买1手、买1报价、买2手、买2报价、…、买5报价、…、卖5报价、日期、时间”。
     *
     * @param stockCode
     * @param stockType
     * @return
     */
    @Transactional
    public StockSeccodsPriceVo detail(String stockCode, int stockType) {

        String symbol = (stockType == 0 ? "sh" : "sz") + stockCode;
        String url = "http://hq.sinajs.cn/list=";

        String result = OkHttpUtils.httpGet(url + symbol);

        if (StringUtils.isEmpty(result) || StringUtils.isEmpty(result.substring(result.indexOf("\"") + 1))) {
            return null;
        }
//        System.out.println(result);
        String[] split = result.substring(result.indexOf("\"") + 1).split(",");
//        logger.info("股票信息数据大小 size={},result={}", split.length, result);
        if (split.length < 32) {
            return null;
        }
        StockSeccodsPriceVo stock = new StockSeccodsPriceVo();
        stock.setStockName(split[0]);
        stock.setStockCode(stockCode);
        stock.setStockType(stockType);
        stock.setOpen(JavaTypeUtils.toFloat(split[1]));
        stock.setYestClose(JavaTypeUtils.toFloat(split[2]));
        stock.setClose(JavaTypeUtils.toFloat(split[3]));
        stock.setHigh(JavaTypeUtils.toFloat(split[4]));
        stock.setLow(JavaTypeUtils.toFloat(split[5]));
        stock.setBuyPrice(JavaTypeUtils.toFloat(split[6]));
        stock.setSellPrice(JavaTypeUtils.toFloat(split[7]));
        stock.setVolume(JavaTypeUtils.toLong(split[8]));
        stock.setMoney(JavaTypeUtils.toFloat(split[9]));


        stock.setBuy1(JavaTypeUtils.toLong(split[10]));
        stock.setBuyPrice1(JavaTypeUtils.toFloat(split[11]));

        stock.setBuy2(JavaTypeUtils.toLong(split[12]));
        stock.setBuyPrice2(JavaTypeUtils.toFloat(split[13]));

        stock.setBuy3(JavaTypeUtils.toLong(split[14]));
        stock.setBuyPrice3(JavaTypeUtils.toFloat(split[15]));

        stock.setBuy4(JavaTypeUtils.toLong(split[16]));
        stock.setBuyPrice4(JavaTypeUtils.toFloat(split[17]));

        stock.setBuy5(JavaTypeUtils.toLong(split[18]));
        stock.setBuyPrice5(JavaTypeUtils.toFloat(split[19]));


        stock.setSell1(JavaTypeUtils.toLong(split[20]));
        stock.setSellPrice1(JavaTypeUtils.toFloat(split[21]));

        stock.setSell2(JavaTypeUtils.toLong(split[22]));
        stock.setSellPrice2(JavaTypeUtils.toFloat(split[23]));

        stock.setSell3(JavaTypeUtils.toLong(split[24]));
        stock.setSellPrice3(JavaTypeUtils.toFloat(split[25]));

        stock.setSell4(JavaTypeUtils.toLong(split[26]));
        stock.setSellPrice4(JavaTypeUtils.toFloat(split[27]));

        stock.setSell5(JavaTypeUtils.toLong(split[28]));
        stock.setSellPrice5(JavaTypeUtils.toFloat(split[29]));

        try {
            String date = split[30].trim() + " " + split[31].trim();
            logger.info("sina data={}", date);
            if (date.length() < 12) {
                stock.setTime(sdf.parse(date.trim()));
            } else {
                stock.setTime(sdfH.parse(date));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return stock;
    }


    /**
     * 返回结果：获取5、10、30、60分钟JSON数据；day日期、open开盘价、high最高价、low最低价、close收盘价、volume成交量；向前复权的数据。
     *
     * @param symbol
     * @param scale
     * @param datalen
     * @return
     */
    public String getKLineData(String symbol, Integer scale, Integer datalen) {

        String url = new StringBuilder()
                .append("http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=")
                .append(symbol)
                .append("&scale=")
                .append(scale)
                .append("&ma=no&datalen=")
                .append(datalen)
                .toString();

        return OkHttpUtils.httpGet(url);
    }


    /**
     * 股票日期的股价JSON数据。
     *
     * @param symbol
     * @param date
     * @return
     */
    public String qianfuquan(String symbol, String date) {

        String url = new StringBuilder()
                .append("http://finance.sina.com.cn/realstock/company/")
                .append(symbol)
                .append("/qianfuquan.js?d=")
                .append(date)
                .toString();

        return OkHttpUtils.httpGet(url);
    }


    /**
     * HTML文本；指定日期范围内的股票分价表。
     *
     * @param symbol
     * @param startdate
     * @param enddate
     * @return
     */
    public String pricehis(String symbol, String startdate, String enddate) {

        String url = new StringBuilder()
                .append("http://market.finance.sina.com.cn/pricehis.php?symbol=")
                .append(symbol)
                .append("&startdate=")
                .append(startdate)
                .append("&enddate=")
                .append(enddate)
                .toString();

        return OkHttpUtils.httpGet(url);
    }

}
