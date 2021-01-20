package com.wdke.stock.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

/**
 * redis分布式锁
 *
 * @Author: wdke
 * @Date: 2020-10-30 15:18
 * @Version: 1.0
 */
public class RedisLockUtils {

    private static final Logger log = LoggerFactory.getLogger(RedisLockUtils.class);

    //锁名称前缀
    public static final String LOCK_PREFIX = "redis_lock";
    //加锁失效时间，毫秒
    public static final int LOCK_EXPIRE = 600; // ms

    private static RedisTemplate redisTemplate;



    public static void init(RedisTemplate redisTemplate){
        redisTemplate=redisTemplate;
    }
    /**
     * 获得锁
     *
     * @param lock
     * @return
     */
    public static boolean lock(String lock) {
        return (boolean) redisTemplate.execute((RedisCallback) connection -> {
            //获取时间毫秒值
            long expireAt = System.currentTimeMillis() + LOCK_EXPIRE + 1;
            //获取锁
            Boolean acquire = connection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());
            if (acquire) {
                return true;
            } else {
                byte[] bytes = connection.get(lock.getBytes());
                //非空判断
                if (Objects.nonNull(bytes) && bytes.length > 0) {
                    long expireTime = Long.parseLong(new String(bytes));
                    // 如果锁已经过期
                    if (expireTime < System.currentTimeMillis()) {
                        // 重新加锁，防止死锁
                        byte[] set = connection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + LOCK_EXPIRE + 1).getBytes());
                        return Long.parseLong(new String(set)) < System.currentTimeMillis();
                    }
                }
            }
            return false;
        });
    }


    /**
     * 删除锁
     *
     * @param key
     */
    public static void deleteLock(String key) {
        redisTemplate.delete(key);
    }
}
