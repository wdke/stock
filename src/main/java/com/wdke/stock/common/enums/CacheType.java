package com.wdke.stock.common.enums;

/**
 * @Author: wdke
 * @Date: 2020-11-14 22:37
 * @Version: 1.0
 */
public enum CacheType{
    GENERIC,
    JCACHE,
    EHCACHE,
    HAZELCAST,
    INFINISPAN,
    COUCHBASE,
    REDIS,
    CAFFEINE,
    GUAVA,
    SIMPLE,
    NONE;

    private CacheType() {
    }
}
