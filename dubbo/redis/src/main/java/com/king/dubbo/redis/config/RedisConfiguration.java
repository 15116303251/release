package com.king.dubbo.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

@EnableCaching
@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {


    //todo 有待修改
    public KeyGenerator keyGenerator(){

        //配置自定义key的生成规则
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //格式化缓存key字符串
                StringBuilder sb =new StringBuilder();
                //追加类名
                sb.append(o.getClass().getName());
                //追加方法名
                sb.append(method.getName());
                //遍历参数并且追加
                for(Object o1:objects){
                    sb.append(o1.toString());
                }
                return sb.toString();
            }
        };
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){

//        使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om=new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisTemplate<String,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(factory);

        RedisConverter redisConverter=new RedisConverter<>(Object.class);
        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);        //设置小范围内的白名单 ParserConfig.getGlobalInstance().addAccept("");
        template.setValueSerializer(redisConverter);

        template.setKeySerializer(new StringRedisSerializer());//使用StringRedisSerializer来序列化和反序列化redis的key值
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory){
        RedisCacheManager redisCacheManager=RedisCacheManager.create(connectionFactory);
        return redisCacheManager;
    }
}
