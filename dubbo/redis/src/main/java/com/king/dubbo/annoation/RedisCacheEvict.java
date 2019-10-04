package com.king.dubbo.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 删除缓存
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCacheEvict {

    String key() default "";

    /**
     * 存储键值的key
     */
    String fieldKey() default "";
}
