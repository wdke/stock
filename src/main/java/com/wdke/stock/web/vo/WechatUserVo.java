package com.wdke.stock.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wdke
 * @Date: 2020-11-13 17:50
 * @Version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WechatUserVo implements Serializable {
    private String openid;

    private String session_key;

    private String unionid;

    private Integer errcode;

    private String errmsg;

    public boolean isSuccess() {
        return null == errcode || errcode == 0;
    }
}
