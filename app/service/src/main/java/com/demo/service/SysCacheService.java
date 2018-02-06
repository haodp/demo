package com.demo.service;import org.springframework.stereotype.Service;import com.demo.common.constants.CacheKeyConstants;import com.demo.common.util.JsonMapper;import com.demo.redis.RedisPool;import com.google.common.base.Joiner;import lombok.NonNull;import lombok.extern.slf4j.Slf4j;/** * Created by yagu on 16/2/4. */@Slf4j@Servicepublic class SysCacheService {    // @Resource(name = "redisPool")    private RedisPool redisPool;    /**     * 添加缓存数据     *     * @param toSavedValue   要保存的数据,必须序列化     * @param timeoutSeconds 缓存失效时间,单位:秒     * @param prefix         缓存key前缀     */    public void saveCache(String toSavedValue, int timeoutSeconds, @NonNull CacheKeyConstants prefix) {        saveCache(toSavedValue, timeoutSeconds, prefix, null);    }    /**     * 添加缓存数据     *     * @param toSavedValue   要保存的数据,必须序列化     * @param timeoutSeconds 缓存失效时间,单位:秒     * @param prefix         缓存key前缀     * @param keys           缓存key的每一项     */    public void saveCache(String toSavedValue, int timeoutSeconds, @NonNull CacheKeyConstants prefix, String... keys) {        if (toSavedValue == null) { // 空值不被保存,返回为空时代表出现异常情况            return;        }        try {            String cacheKey = generateKey(prefix, keys);            redisPool.instance().setex(cacheKey, timeoutSeconds, toSavedValue);        } catch (Throwable t) {            log.error("save cache exception, prefix:{}, keys:{}", prefix.name(), JsonMapper.obj2String(keys), t);        }    }    /**     * 失效缓存数据     *     * @param prefix 缓存key前缀     * @param keys   缓存key的每一项     */    public void delCache(@NonNull CacheKeyConstants prefix, String... keys) {        try {            String cacheKey = generateKey(prefix, keys);            redisPool.instance().del(cacheKey);        } catch (Throwable t) {            log.error("expire cache exception, prefix:{}, keys:{}", prefix.name(), JsonMapper.obj2String(keys), t);        }    }    /**     * 从cache获取指定key的数据     * 注意:为空时代表获取出现异常     *     * @param clazz  返回的类型     * @param prefix 缓存key的前缀     * @param keys   缓存key的每一项     * @return 缓存中数据     */    public String getFromCache(@NonNull Class clazz, @NonNull CacheKeyConstants prefix, String... keys) {        String cacheKey = generateKey(prefix, keys);        try {            return redisPool.instance().get(cacheKey);        } catch (Throwable t) {            log.error("get from cache exception, prefix:{}, keys:{}", prefix.name(), JsonMapper.obj2String(keys), t);        }        return null;    }    /**     * 生成cache key     *     * @param prefix 前缀     * @param keys   组成key的列表     * @return prefix-K1-K2...-Kn:     */    private String generateKey(CacheKeyConstants prefix, String... keys) {        String key = prefix.name();        if (keys != null && keys.length > 0) {            key += "-" + Joiner.on("-").join(keys);        }        key += ":";        return key;    }}