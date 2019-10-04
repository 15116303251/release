package com.king.controller.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogRequestAspect {


    private Logger logger= LoggerFactory.getLogger(LogRequestAspect.class);
    @Pointcut("execution(public * com.king.controller.*.*.*(..))")
    public void webLog(){};

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)throws Throwable{
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //输出请求的内容
        logger.info("=============请求进入了api网关=============》");
        logger.info("URL:"+request.getRequestURL().toString());
        logger.info("HTTP_METHOD:"+request.getMethod());
        logger.info("IP:"+request.getRemoteAddr());
        logger.info("CLASS_METHOD:"+joinPoint.getSignature().getName());
        logger.info("PARAMETERS:"+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "result",pointcut = "webLog()")
    public void doAfterReturning(Object result){
        logger.info("RESULT:请求已经结束相关资源的释放，返回的结果为："+result);
    }

    @AfterThrowing("webLog()")
    public void doThrows(JoinPoint joinPoint){
        logger.info("方法的执行出现异常："+joinPoint.getSignature().getName());
    }

    @After("webLog()")
    public void after(JoinPoint joinPoint){
        logger.info("==============api调用执行完毕==============》");
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){
        Object object=null;
        try {
            long startTime=System.currentTimeMillis();
            object=proceedingJoinPoint.proceed();
            long endTime=System.currentTimeMillis();
            logger.info("方法执行后返回的结果："+"耗时："+(endTime-startTime)+"毫秒");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

}
