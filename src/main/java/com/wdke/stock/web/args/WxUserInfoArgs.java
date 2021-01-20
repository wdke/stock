package com.wdke.stock.web.args;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: wdke
 * @Date: 2020-11-11 15:25
 * @Version: 1.0
 */
@Data
public class WxUserInfoArgs {

    private String avatarUrl;

    private String cloudID;

    private String city;

    private String country;

    private Integer gender;

    private String language;

    private String province;

    private String iv;

    @NotBlank(message = "不能为空")
    private String nickName;


    private String encryptedData;

    @NotBlank(message = "不能为空")
    private String code;
}
