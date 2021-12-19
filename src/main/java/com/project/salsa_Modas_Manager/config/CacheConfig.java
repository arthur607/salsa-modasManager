package com.project.salsa_Modas_Manager.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//@EnableCaching
//public class CacheConfig {
//    @Bean
//    public RedisTemplate<Object, Object> sessionRedisTemplate(
//            RedisConnectionFactory connectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        if (this.defaultRedisSerializer != null) {
//            template.setDefaultSerializer(this.defaultRedisSerializer);
//        }
//        template.setConnectionFactory(connectionFactory);
//        return template;
//    }
//
//    @Bean
//    public RedisTemplate<Object, Object> sessionRedisTemplate(
//            RedisConnectionFactory connectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//
//        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
//
//        template.setConnectionFactory(connectionFactory);
//        return template;
//    }
//}
