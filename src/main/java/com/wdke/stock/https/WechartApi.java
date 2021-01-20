package com.wdke.stock.https;

import com.alibaba.fastjson.JSON;
import com.wdke.stock.common.consts.WechatConstant;
import com.wdke.stock.utils.OkHttpUtils;
import com.wdke.stock.web.vo.WechatUserVo;
import org.springframework.stereotype.Component;

/**
 * @Author: wdke
 * @Date: 2020-11-13 17:30
 * @Version: 1.0
 */
@Component
public class WechartApi {


    /**
     * 获取用户惟一标志
     *
     * @param jscode
     * @return
     */
    public WechatUserVo jscode2session(String jscode) {


        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code&appid=")
                .append(WechatConstant.APPLET_APP_ID)
                .append("&secret=").append(WechatConstant.APPLET_APPSECRET)
                .append("&js_code=").append(jscode);


        String result = OkHttpUtils.httpGet(url.toString());
        WechatUserVo wechatUser = JSON.parseObject(result, WechatUserVo.class);
        return wechatUser;
    }
}
