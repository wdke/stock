package com.wdke.stock.web.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 股票页面
 *
 * @Author: wdke
 * @Date: 2020-10-22 17:45
 * @Version: 1.0
 */
@Controller
@RequestMapping("page/stock")
public class PageStockController {


    @RequestMapping(value = "", name = "首页接口")
    public String index() {

        return "index";
    }


    @RequestMapping(value = "mobile", name = "首页接口")
    public String mobile() {

        return "mobile";
    }
}
