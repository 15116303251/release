package com.king.dubbo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

public class BaseAspect {

    public Logger log= LogManager.getLogger(BaseAspect.class);

    /**
     * 获取被拦截方法对象
     * MethodSignature.getMethod() 获取的是顶层接口或者父类的方法对象
     * 而缓存的注解在实现类的方法上
     * 所以应该使用反射获取当前对象的方法对象
     */
    public Method getMethod(ProceedingJoinPoint proceedingJoinPoint) {
        //获取参数的类型
        Object[] args = proceedingJoinPoint.getArgs();
        Class[] argsTypes = new Class[args.length];

        for (int i = 0; i < args.length; i++) {
            argsTypes[i] = args[i].getClass();
        }

        try {
            return proceedingJoinPoint.getTarget().getClass().getMethod(proceedingJoinPoint.getSignature().getName(), argsTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *获取缓存的key
     *定义在注解上，支持SPEL表达式
     *(1)key为全文本，没有spel表达式
     *(2)key全为spel表达式
     *(3)key中包含spel表达式
     * @param method
     * @param args
     * @return
     */
    public String parseKey(String key, String fieldKey, Method method, Object[] args) {

        //获取被拦截方法参数名列表（使用spring支持的类库）
        LocalVariableTableParameterNameDiscoverer paramFind = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNameAttr = paramFind.getParameterNames(method);

        ExpressionParser parser = new SpelExpressionParser();

        //SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        //把方法参数放入SPEL上下文中
        for (int i = 0; i < paramNameAttr.length; i++) {
            context.setVariable(paramNameAttr[i], args[i]);
        }
        return key + "_" + parser.parseExpression(fieldKey).getValue(context, String.class);
    }

}
