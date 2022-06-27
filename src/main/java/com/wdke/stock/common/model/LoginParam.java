package com.wdke.stock.common.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * created by wdk on 2019/12/12
 */
@Data
public class LoginParam {

    //用户名
    @NotBlank(message = "cannot be empty")
    private String username;

    //用户密码
    @NotBlank(message = "cannot be empty")
    private String password;
}
