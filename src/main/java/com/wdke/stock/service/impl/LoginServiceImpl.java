package com.wdke.stock.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.https.WechartApi;
import com.wdke.stock.service.LoginService;
import com.wdke.stock.storage.dao.SysUserMapper;
import com.wdke.stock.storage.dao.WechatUserMapper;
import com.wdke.stock.storage.entity.SysUser;
import com.wdke.stock.storage.entity.SysUserExample;
import com.wdke.stock.storage.entity.WechatUser;
import com.wdke.stock.utils.JwtUtils;
import com.wdke.stock.utils.PasswordUtil;
import com.wdke.stock.web.args.SysUserArgs;
import com.wdke.stock.web.args.WxUserInfoArgs;
import com.wdke.stock.web.interceptor.UserContext;
import com.wdke.stock.web.vo.WechatUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by wdk on 2019/12/22
 */
@Service
public class LoginServiceImpl implements LoginService {


    private static Logger logger = LoggerFactory.getLogger(LoginService.class);


    @Autowired
    private ValueOperations<String, String> redis;


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private WechatUserMapper wechatUserMapper;

    @Autowired
    private WechartApi wechartApi;

    /**
     * 登陆接口
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResponseVo<String> login(String username, String password) {
        //查询用户信息
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username);
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);


        if (list.isEmpty()) {
            logger.info("login  用户不存在 .username={}", username);
            return new ResponseVo(ResponseStatusEnum.PARRAM_ERROR.getCode(), "用户不存在");
        } else {
            for (SysUser user : list) {
                if (PasswordUtil.encrypt(password, user.getPasswordKey()).equals(user.getPassword())) {

                    //生成 token
                    Map<String, Object> map = new HashMap<>();
                    map.put("username", username);
                    map.put("userId", user.getId());
                    String token = JwtUtils.createJWT(map);

                    //保存到 redis
//                    redis.set(token, JSON.toJSONString(user), RedisConstant.TOKEN_TIME);
//                    redis.set(UserContext.current().getRequest().getSession().getId(), JSON.toJSONString(user), RedisConstant.TOKEN_TIME);

                    UserContext.current().getRequest().getSession().setAttribute("userId", user.getId());

                    UserContext.current().getRequest().getSession().setAttribute("username", username);

                    UserContext.current().getRequest().getSession().setAttribute("commissionRate", user.getCommissionRate());

                    return new ResponseVo(ResponseStatusEnum.SUCCESS.getCode(), "登录成功", token);
                }
            }
        }

        logger.info("login 登录失败。username={}", username);
        return new ResponseVo(ResponseStatusEnum.PARRAM_ERROR.getCode(), "登陆失败，密码错误。");

    }


    /**
     * 校验token
     *
     * @param tokenValue
     * @return
     */
    @Override
    public ResponseVo<Boolean> tokenCheck(String tokenValue) {
        String check = redis.get(tokenValue);
        if (StringUtils.isEmpty(check)) {
            return new ResponseVo(ResponseStatusEnum.SUCCESS, false);
        }
        return new ResponseVo(ResponseStatusEnum.SUCCESS, true);
    }

    /**
     * 注册
     *
     * @param param
     * @return
     */
    @Override
    public ResponseVo<Integer> register(SysUserArgs param) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria()
                .andUsernameEqualTo(param.getUsername());
        //验证用户名是否存在
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        if (!list.isEmpty()) {
            return new ResponseVo<>(ResponseStatusEnum.USER_ISLIVE);
        }
        sysUserExample.clear();
        sysUserExample.createCriteria()
                .andPhoneEqualTo(param.getPhone());
        //验证电话是否唯一
        list = sysUserMapper.selectByExample(sysUserExample);
        if (!list.isEmpty()) {
            return new ResponseVo<>(ResponseStatusEnum.PHONE_ISLIVE);
        }
        if (!StringUtils.isEmpty(param.getEmail())) {

            sysUserExample.clear();
            sysUserExample.createCriteria()
                    .andEmailEqualTo(param.getEmail());

            //验证电话是否唯一
            list = sysUserMapper.selectByExample(sysUserExample);
            if (!list.isEmpty()) {
                return new ResponseVo<>(ResponseStatusEnum.EMAIL_ISLIVE);
            }
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(param, sysUser);
        int result = sysUserMapper.insertSelective(sysUser);

        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 微信认证校验
     *
     * @param userInfoArgs
     * @return
     */
    @Override
    @Transactional
    public ResponseVo<String> wechatCheck(WxUserInfoArgs userInfoArgs) {

        WechatUserVo wechatUserVo = wechartApi.jscode2session(userInfoArgs.getCode());
        if (!wechatUserVo.isSuccess()) {
            return new ResponseVo<>(ResponseStatusEnum.ERROR);

        }
        WechatUser wechatUser = wechatUserMapper.selectByPrimaryKey(wechatUserVo.getOpenid());
        if (null == wechatUser) {

            SysUserExample example = new SysUserExample();
            example.createCriteria()
                    .andOpenidEqualTo(wechatUserVo.getOpenid());
            List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
            int userId = 0;
            SysUser sysUser = new SysUser();
            if (sysUsers.isEmpty()) {
                sysUser.setOpenid(wechatUserVo.getOpenid());
                userId = sysUserMapper.insertSelective(sysUser);
            } else {
                sysUser = sysUsers.get(0);
            }

            if (sysUser.getId() > 0) {
                wechatUser = new WechatUser();
                BeanUtils.copyProperties(userInfoArgs, wechatUser);
                wechatUser.setUserId(sysUser.getId());
                wechatUser.setOpenid(wechatUserVo.getOpenid());
                wechatUser.setUnionid(wechatUserVo.getUnionid());
                wechatUserMapper.insertSelective(wechatUser);
                //生成 token
                Map<String, Object> map = new HashMap<>();
                map.put("openId", wechatUserVo.getOpenid());
                map.put("userId", sysUser.getId());
                String token = JwtUtils.createJWT(map);
                return new ResponseVo<>(ResponseStatusEnum.SUCCESS, token);
            }
            return new ResponseVo<>(ResponseStatusEnum.ERROR);
        } else {
            //生成 token
            Map<String, Object> map = new HashMap<>();
            map.put("userId", wechatUser.getUserId());
            map.put("openId", wechatUserVo.getOpenid());
            String token = JwtUtils.createJWT(map);
            return new ResponseVo<>(ResponseStatusEnum.SUCCESS, token);
        }
    }


}
