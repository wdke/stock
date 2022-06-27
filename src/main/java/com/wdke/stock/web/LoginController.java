package com.wdke.stock.web;

import com.wdke.stock.common.model.LoginParam;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.LoginService;
import com.wdke.stock.utils.PasswordUtil;
import com.wdke.stock.web.args.SysUserArgs;
import com.wdke.stock.web.args.WxUserInfoArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 登陆接口
 *
 * @Author: wdke
 * @Date: 2020-04-03 11:27
 * @Version: 1.0
 */
@RestController
@RequestMapping("stock")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登陆验证
     *
     * @return
     */
    @PostMapping(value = "login", name = "登陆验证")
    public ResponseVo<String> login(@RequestBody @Valid LoginParam loginParam) {

        //判断登陆
        ResponseVo<String> result = loginService.login(loginParam.getUsername(), loginParam.getPassword());


        return result;
    }

    /**
     * 注册
     *
     * @return
     */
    @PostMapping(value = "wechat/check", name = "注册")
    public ResponseVo<String> wechatCheck(@Valid @RequestBody WxUserInfoArgs userInfoArgs) {

        //密码加密
        //保存注册信息
        ResponseVo<String> result = loginService.wechatCheck(userInfoArgs);


        return result;
    }

    /**
     * 注册
     *
     * @return
     */
    @PostMapping(value = "register", name = "注册")
    public ResponseVo<Integer> register(@Valid @RequestBody SysUserArgs sysUserArgs) {

        //密码加密
        sysUserArgs.setPassword(PasswordUtil.encrypt(sysUserArgs.getPassword(), sysUserArgs.getUsername()));
        sysUserArgs.setPasswordKey(sysUserArgs.getUsername());

        //保存注册信息
        ResponseVo<Integer> result = loginService.register(sysUserArgs);


        return result;
    }

}
