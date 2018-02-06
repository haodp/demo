package com.chen.service;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.chen.util.Constants;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author xinhc 
 * 较智能的缓存
 *
 */

@Service
public class GCacheService {
    private static final Logger log = Logger.getLogger(GCacheService.class);
    private Cache<String, String> cache;

    public GCacheService() {
        cache = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(Constants.TOKEN_EXPIRE, TimeUnit.SECONDS)
            .build();
        getToken(Constants.TOKEN_KEY);
    }

    public String getToken(String key) {
        String token = StringUtils.EMPTY;

        try {
            token = cache.get(key, new Callable<String>() {
                @Override
                public String call() {
                    // TODO
                    Random random = new Random();
                    int randNum = random.nextInt(1234) + 100000;
                    log.info("-------------token------------" + randNum);
                    return String.valueOf(randNum);
                }
            });
        } catch (ExecutionException | NullPointerException | Error e) {
            log.error("-------------------" + e);
        }

        return token;
    }
}
