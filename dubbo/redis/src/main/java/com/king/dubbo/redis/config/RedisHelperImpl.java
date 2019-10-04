package com.king.dubbo.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("redisHelper")
public class RedisHelperImpl<HK,T> implements RedisHelper<HK,T> {

    private RedisTemplate<String,T>redisTemplate;
    // 在构造器中通过redisTemplate的工厂方法实例化操作对象
    private HashOperations<String, HK, T> hashOperations;
    private ListOperations<String, T> listOperations;
    private ZSetOperations<String, T> zSetOperations;
    private SetOperations<String, T> setOperations;
    private ValueOperations<String, T> valueOperations;

    @Autowired
    public RedisHelperImpl(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.listOperations = redisTemplate.opsForList();
        this.zSetOperations = redisTemplate.opsForZSet();
        this.setOperations = redisTemplate.opsForSet();
        this.valueOperations = redisTemplate.opsForValue();
    }


    @Override
    public void hashPut(String key, HK hashKey, T domain) {
        hashOperations.put(key, hashKey, domain);
    }

    @Override
    public Map<HK, T> hashFindAll(String key) {
        return hashOperations.entries(key);
    }

    @Override
    public T hashGet(String key, HK hashKey) {
        return hashOperations.get(key, hashKey);
    }

    @Override
    public void hashRemove(String key, HK hashKey) {
        hashOperations.delete(key, hashKey);
    }

    @Override
    public Long listPush(String key, T domain) {
        return listOperations.rightPush(key, domain);
    }


    @Override
    public List<T> listFindAll(String key) {
        if (!redisTemplate.hasKey(key)) {
            return null;
        }
        return listOperations.range(key, 0, listOperations.size(key));
    }

    @Override
    public T listPop(String key) {
        return listOperations.leftPop(key);
    }

    @Override
    public void putObjectValue(String key, T domain) {
        valueOperations.set(key, domain);
    }

    @Override
    public T getObjectValue(String key) {
        return valueOperations.get(key);
    }

    @Override
    public void removeObject(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeout, timeUnit);
    }

    
}
