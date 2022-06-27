/**
 * @title: newmerchant-xapi
 * @file: TokenInterceptor.java
 * @package: com.wanda.application.xapi.newmerchant.web.interceptor
 * @description: token拦截器
 * @author: jinyi10
 * @email: jinyi10@wanda.cn
 * @time: 2017年3月14日 下午2:55:16
 * @Copyright (c) 2017, Wanda.cn All right reserved.
 */

package com.wdke.stock.web.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.storage.dao.SysUserMapper;
import com.wdke.stock.storage.entity.SysUser;
import com.wdke.stock.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by loutao on 2018/6/20.
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {


    @Autowired
    private ValueOperations<String, String> redis;

    @Autowired
    private SysUserMapper sysUserMapper;

    private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /* 解决跨域请求问题 */
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "HEAD,POST,GET,PUT,DELETE,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,Cache-Control,Pragma,Content-Type");

        UserContext.current().setRequest(request);
        UserContext.current().setResponse(response);
        String traceId = request.getSession().getId();

        UserContext.current().setTraceId(traceId);
        long start = System.currentTimeMillis();
        UserContext.current().setStartTime(start);

        String requestURI = request.getRequestURI();
        if (requestURI.contains("/stock/login")
                || requestURI.contains("/stock/wechat/check")
                || requestURI.contains("/handle")
                || requestURI.contains("/error")
                || requestURI.contains("/page/")
                || requestURI.contains("/stock/register")
                || requestURI.contains("/static/")) {
            logger.info("不需要登陆信息 requestURI->{}", requestURI);
            return true;
        }

        String token = request.getHeader("T-Validate-Token");
        logger.info("T-Validate-Token={}",token);
        if (!StringUtils.isEmpty(token) && JwtUtils.isVerify(token)) {

            Claims claims = JwtUtils.parseJWT(token);
            Object userId = claims.get("userId");
            if (null != userId) {
                UserContext.current().setUserId(Long.valueOf(userId.toString()));
                SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(userId.toString()));
                UserContext.current().setCommissionRate(sysUser.getCommissionRate());
//                redis.increment(userId.toString(), 1);
                logger.info("通过T-Validate-Token登陆 userid={}", userId.toString());
                return true;
            }
        }

        token = request.getHeader("Wechat-Validate-Token");
        logger.info("Wechat-Validate-Token={}",token);
        if (!StringUtils.isEmpty(token) && JwtUtils.isVerify(token)) {

            Claims claims = JwtUtils.parseJWT(token);
            Object userId = claims.get("userId");
            if (null != userId) {
                UserContext.current().setUserId(Long.valueOf(userId.toString()));
                SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(userId.toString()));
                UserContext.current().setCommissionRate(sysUser.getCommissionRate());
//                redis.increment(userId.toString(), 1);
                logger.info("通过Wechat-Validate-Token登陆 userid={}", userId.toString());
                return true;
            }
        }

        Long userId = (Long) UserContext.current().getRequest().getSession().getAttribute("userId");

        logger.info("userId={}",userId);
        Float commissionRate = (Float) UserContext.current().getRequest().getSession().getAttribute("commissionRate");
        String username = (String) UserContext.current().getRequest().getSession().getAttribute("username");
        if (null != userId) {

            UserContext.current().setUserId(userId);
            UserContext.current().setUsername(username);
            UserContext.current().setCommissionRate(commissionRate);
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(userId.toString()));
            UserContext.current().setCommissionRate(sysUser.getCommissionRate());
//            redis.increment(userId.toString(), 1);
            logger.info("通过sission登陆 userid={}", userId.toString());
            return true;
        }

        if (requestURI.contains("/stock/info/snalysis/list")) {
            logger.info("可以直接返回 requestURI->{}", requestURI);
            return true;
        }
        request.setAttribute("Accept", "/");
        response.setHeader("Content-type",
                "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        ResponseVo results = new ResponseVo(ResponseStatusEnum.INVALID_TOKEN.getCode(), "无权限操作");
        response.getWriter().write(JSON.toJSONString(results));
        response.getWriter().close();
        logger.info("preHandle end  result->getRequestURI->【URI{}】, ", request.getRequestURI());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long start = UserContext.current().getStartTime();
        long duration = System.currentTimeMillis() - start;
        if (duration > 3000) {
            logger.info("超时报警短信【__trace_id：{}】【duration：{}】", UserContext.current().getTraceId(), duration);
        }
        UserContext.release();
    }

    private boolean preHandleService(HttpServletRequest request, HttpServletResponse response) {

        /**
         * 处理用户信息
         */
        if (!initUserInfo(request, response)) {
            return false;
        }
        return true;
    }


    /**
     * 处理用户信息
     *
     * @param request
     * @param response
     * @return
     */
    public boolean initUserInfo(HttpServletRequest request, HttpServletResponse response) {

        Long userId = (Long) request.getSession().getAttribute("userId");
        UserContext.current().setUserId(userId);

        String username = (String) request.getSession().getAttribute("username");
        if (StringUtils.isEmpty(username)) {
            return false;
        }

        UserContext.current().setUsername(username);
        return true;
    }

}
