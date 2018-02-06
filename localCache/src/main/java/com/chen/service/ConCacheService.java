package com.chen.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xinhc 
 * 简单的jvm缓存
 *
 */

@Getter
@Setter
@Service
public class ConCacheService {
    private Map<Object, Object> cachePool;
    
    public ConCacheService(){
        cachePool = new ConcurrentHashMap<>();
    }
}
