package com.wdke.stock.service;


import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.web.args.SysUserArgs;
import com.wdke.stock.web.args.WxUserInfoArgs;

/**
 * created by wdk on 2019/12/22
 */
public interface LoginService {

    /**
     * 登陆接口
     *
     * @param username
     * @param password
     * @return
     */
    ResponseVo<String> login(String username, String password);


    /**
     * 校验token
     *
     * @param tokenValue
     */
    ResponseVo<Boolean> tokenCheck(String tokenValue);


    /**
     * 注册
     *
     * @param param
     * @return
     */
    ResponseVo<Integer> register(SysUserArgs param);

    /**
     * 微信认证校验
     *
     * @param userInfoArgs
     * @return
     */
    ResponseVo<String> wechatCheck(WxUserInfoArgs userInfoArgs);
}
