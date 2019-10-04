package com.king.dubbo.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {

    /**
     * 用于支持原先的spel表达式
     */
    String key() default "";

    /**
     * 存储键值的key
     */
    String fieldKey() default "";

    /**
     * 设置过期时间
     */
    long expireTime() default 6000l;

    /**
     * 设置过期时间的单位
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
