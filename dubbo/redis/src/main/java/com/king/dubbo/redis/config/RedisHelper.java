package com.king.dubbo.redis.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface RedisHelper<HK,T> {


    // Hash结构 添加元素
    void hashPut(String key, HK hashKey, T domain);

    //Hash结构 获取指定key所有键值对

    Map<HK, T> hashFindAll(String key);

    //哈希结构获取单个元素
    T hashGet(String key, HK hashKey);

    //哈希移除某个值
    void hashRemove(String key, HK hashKey);

    //list结构，向尾部添加元素
    Long listPush(String key, T domain);

    //List结构 获取所有的元素
    List<T>listFindAll(String key);

    //List结构，移除并获取数组第一个元素
    T listPop(String key);

    //保存对象实体
    void putObjectValue(String key, T domain);

    //获取对象实体类
    T getObjectValue(String key);

    //移除对象实体
    void removeObject(String key);

    //设置过期时间
    Boolean expire(String key, long timeout, TimeUnit timeUnit);
}
