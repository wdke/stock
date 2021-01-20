package com.wdke.stock.web.vo;

import lombok.Data;

/**
 * @Author: wdke
 * @Date: 2020-11-13 17:50
 * @Version: 1.0
 */
@Data
public class WechatUserVo {
    private String openid;

    private String session_key;

    private String unionid;

    private Integer errcode;

    private String errmsg;

    public boolean isSuccess() {
        return null == errcode || errcode == 0;
    }
}
