package com.xxxx.ddd.infrastructure.cache.redis;

import java.util.concurrent.TimeUnit;

public interface RedisInfrasService {
    // name = "anonystick"
    void setString(String key, String value);
    String getString(String key);

    void setObject(String key, Object value);
    void setObjectTTL(String key, Object value, Long ttl);
    <T> T getObject(String key, Class<T> targetClass);

    void deleteObject(String key);

//    void put(String key, Object value, long timeout, TimeUnit unit);
//
//    void put(String key, Object value, long expireTime);
}
