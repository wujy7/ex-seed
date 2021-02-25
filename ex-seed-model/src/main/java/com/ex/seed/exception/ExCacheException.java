package com.ex.seed.exception;

import org.springframework.util.ClassUtils;

/**
 * 缓存异常类
 */
public class ExCacheException extends RuntimeException {

    private final String key;

    private final Class<?> requiredType;

    private final Class<?> actualType;

    public ExCacheException(String key, Class<?> requiredType, Class<?> actualType) {
        super("Key named '" + key + "' is expected to be of type '" + ClassUtils.getQualifiedName(requiredType) + "' but was actually of type '" + ClassUtils.getQualifiedName(actualType) + "'");
        this.key = key;
        this.requiredType = requiredType;
        this.actualType = actualType;
    }

    public String getKey() {
        return this.key;
    }

    public Class<?> getRequiredType() {
        return this.requiredType;
    }

    public Class<?> getActualType() {
        return this.actualType;
    }

}
