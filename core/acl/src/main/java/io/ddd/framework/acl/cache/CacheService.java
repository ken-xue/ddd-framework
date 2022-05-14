package io.ddd.framework.acl.cache;

import java.util.concurrent.TimeUnit;

/**
 * @author mikey
 */
public interface CacheService<K,V> {
    V get(K k);
    void set(K k,V v);
    /**
     * 设置缓存
     * @param k 键
     * @param v 值
     * @param expire 过期时间
     * @param timeUnit 过期时间单位
     */
    void set(K k, V v, Long expire, TimeUnit timeUnit);
}
