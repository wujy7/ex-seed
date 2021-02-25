package com.ex.seed.utils;

import com.ex.seed.exception.ExCacheException;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheUtil {

    private static Cache<String, Object> cache
            = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build();

    /**
     * 获取guava本地缓存
     * @param key
     * @param requiredType
     * @param <T>
     * @return
     * @throws ExCacheException
     */
    public static <T> T get(String key,Class<T> requiredType) throws ExCacheException {
        Object cacheVal = cache.getIfPresent(key);
        if (cacheVal != null && requiredType != null && !requiredType.isInstance(cacheVal)) {
            throw new ExCacheException(key, requiredType, cacheVal.getClass());
        } else {
            return (T) cacheVal;
        }
    }

    /**
     * 保存缓存
     * @param key
     * @param val
     */
    public static void put(String key,Object val) {
        cache.put(key,val);
    }

    /**
     * 删除缓存
     * @param key
     */
    public static void remove(String key) {
        cache.invalidate(key);
    }

}
