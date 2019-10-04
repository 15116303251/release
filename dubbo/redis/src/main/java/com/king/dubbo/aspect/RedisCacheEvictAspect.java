package com.king.dubbo.aspect;


import com.king.dubbo.annoation.RedisCacheEvict;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 未考虑的问题
 * todo 给一个标志用于判断是否进行缓存,若是进行缓存的标志是false,直接执行方法
 * todo 需要考虑过期key是否是立即删除
 */

@Component
@Aspect
public class RedisCacheEvictAspect extends BaseAspect{

    @Autowired
    RedisTemplate redisTemplate;
    Lock reenLock = new ReentrantLock();

    @Pointcut(value = "@annotation(com.king.dubbo.annoation.RedisCacheEvict)")
    public void cacheDelete() {}



    @Around("cacheDelete()")
    public Object cacheDeleteObject(ProceedingJoinPoint proceedingJoinPoint) throws InterruptedException {

        Object[] args = proceedingJoinPoint.getArgs();
        Method method = getMethod(proceedingJoinPoint);

        RedisCacheEvict redisCacheEvict=method.getAnnotation(RedisCacheEvict.class);
        String fieldKey = parseKey(redisCacheEvict.key(), redisCacheEvict.fieldKey(), method, args);
        return deleteDataBaseAndEvictCache(fieldKey,proceedingJoinPoint);

    }

    /**
     * @description 删除数据库数据，清除缓存
     *  1、删除缓存
     *  2、删除数据库
     *  3、等待若干秒
     *  4、再次删除缓存
     * @param fieldKey
     * @param proceedingJoinPoint
     * @return
     * @throws InterruptedException
     */
    public Object deleteDataBaseAndEvictCache(String fieldKey, ProceedingJoinPoint proceedingJoinPoint) throws InterruptedException {

        Object result=null;
        boolean existFlag=redisTemplate.hasKey(fieldKey);

        if(existFlag){

            redisTemplate.delete(fieldKey);
            if (reenLock.tryLock()) {
                try {
                    result = proceedingJoinPoint.proceed();
                    log.info("缓存key为" + fieldKey + "删除数据库中的结果是：" + result);
                    Thread.sleep(1000);
                    redisTemplate.delete(fieldKey);
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    reenLock.unlock();
                }
            } else {

                Boolean resultFlag = redisTemplate.hasKey(fieldKey);
                if (resultFlag) {
                    Thread.sleep(2000);
                    return deleteDataBaseAndEvictCache(fieldKey, proceedingJoinPoint);
                }
            }

        }
        return result;
    }
}
