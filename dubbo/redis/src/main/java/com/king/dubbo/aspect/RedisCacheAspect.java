package com.king.dubbo.aspect;


import com.king.dubbo.annoation.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 未考虑的问题
 * todo 给一个标志用于判断是否进行缓存,若是进行缓存的标志是false,直接执行方法
 * todo 需要考虑过期key是否是立即删除
 */

@Component
@Aspect
public class RedisCacheAspect extends BaseAspect{

    @Autowired
    RedisTemplate redisTemplate;

    private Lock reenLock = new ReentrantLock();


    @Pointcut(value = "@annotation(com.king.dubbo.annoation.RedisCache)")
    public void cache() {}

    @Around("cache()")
    public Object cacheObject(ProceedingJoinPoint proceedingJoinPoint) {

        Object[] args = proceedingJoinPoint.getArgs();
        Method method = getMethod(proceedingJoinPoint);

        RedisCache redisCache = method.getAnnotation(RedisCache.class);
        String fieldKey = parseKey(redisCache.key(), redisCache.fieldKey(), method, args);

        return getCacheResult(fieldKey, proceedingJoinPoint, redisCache);
    }

    /**
     * @description 获取缓存的结果
     * @param fieldKey
     * @param proceedingJoinPoint
     * @param redisCache
     * @throws InterruptedException
     */
    public Object getCacheResult(String fieldKey, ProceedingJoinPoint proceedingJoinPoint, RedisCache redisCache)   {
        Object result = null;

        Boolean flag = redisTemplate.hasKey(fieldKey);

        if (flag) {
            result= redisTemplate.opsForSet().randomMember(fieldKey);
            log.info("缓存key为" + fieldKey + "==>缓存中的结果是：" + result);
            return result;
        }else{
            if (reenLock.tryLock()) {
                try {

                    log.info("当前的进程为"+Thread.currentThread().getName()+"拿到了锁");
                    result = proceedingJoinPoint.proceed();
                    redisTemplate.opsForSet().add(fieldKey, result);

                    if(result==null){
                        redisTemplate.expire(fieldKey, 10+(new Random().nextInt(20)), TimeUnit.SECONDS);
                    }else{
                        redisTemplate.expire(fieldKey, redisCache.expireTime()+(new Random().nextInt(20)), redisCache.timeUnit());
                    }
                    log.info("缓存key为" + fieldKey + "==>查询数据库的结果是：" + result  +"缓存的时间的==>"+redisCache.expireTime()+redisCache.timeUnit());
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    reenLock.unlock();
                }
            } else {
                Boolean secondFlag = redisTemplate.hasKey(fieldKey);
                if(!secondFlag) {
                    result= getCacheResult(fieldKey,proceedingJoinPoint, redisCache);
                }else {
                    result= redisTemplate.opsForSet().randomMember(fieldKey);
                }

            }
        }
        return result;
    }


//    /**
//     * @description 查询数据库并进行缓存的设置
//     * @param setOperations
//     * @param fieldKey
//     * @param proceedingJoinPoint
//     * @param redisCache
//     * @return
//     * @throws InterruptedException
//     */
//    public Object queryDataBaseAndSetCache(SetOperations setOperations,String fieldKey, ProceedingJoinPoint proceedingJoinPoint, RedisCache redisCache) throws InterruptedException {
//
//        Object result=null;
//
//        if (reenLock.tryLock()) {
//            try {
//                result = proceedingJoinPoint.proceed();
//                setOperations.add(fieldKey, result);
//                log.info("缓存key为" + fieldKey + "==>查询数据库的结果是：" + result  +"缓存的时间的==>"+redisCache.expireTime()+redisCache.timeUnit());
//                redisTemplate.expire(fieldKey, redisCache.expireTime(), redisCache.timeUnit());
//
//            } catch (Throwable e) {
//                e.printStackTrace();
//            } finally {
//                reenLock.unlock();
//            }
//        } else {
//            Boolean resultFlag = redisTemplate.hasKey(fieldKey);
//            if (!resultFlag) {
//                Thread.sleep(2000);
//                return queryDataBaseAndSetCache(setOperations,fieldKey,proceedingJoinPoint, redisCache);
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Random random=new Random(20);
        while(true)
        System.out.println(random.nextInt(20));
    }
}
