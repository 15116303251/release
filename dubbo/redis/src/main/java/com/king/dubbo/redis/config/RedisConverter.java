package com.king.dubbo.redis.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * 配置redis 存储对象的序列化与反序列化
 */
public class RedisConverter<T> implements RedisSerializer<T> {

    private Logger logger= LogManager.getLogger(RedisConverter.class);
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Class<T> clazz;

    public RedisConverter(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(Object o) throws SerializationException {

        try{
            if(o!=null){
                return JSON.toJSONString(o, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.info("对象的序列化出现异常"+o);
        }
        return new byte[0];
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        try{
            if(bytes!=null){
                String str = new String(bytes, DEFAULT_CHARSET);
                return JSON.parseObject(str, clazz);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("对象的反序列化出现异常"+bytes);
        }
        return null;
    }
}
