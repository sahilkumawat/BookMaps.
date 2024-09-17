package com.maps.book.service;

import com.maps.book.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPooled;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

// https://github.com/cptdanko/java-redis-jedis-demo/blob/main/src/main/java/com/mdt/tutorial/redis/RedisService.java
@Service
public class RedisService {
    private static final Logger logger = Logger.getLogger(RedisService.class.getName());

    public void p(Object o) {
        logger.info(o.toString());
    }

    private JedisPool getJedisPool() {
        return new JedisPool("127.0.0.1", 6379, "default", "eYVX7EwVmmxKPCDmwMtyKVge8oLd2t81");
    }

    private JedisPooled getPooledJedis() {
        return new JedisPooled("127.0.0.1", 6379, "default", "eYVX7EwVmmxKPCDmwMtyKVge8oLd2t81");
    }
    /**
     * Initial connection and setup of Redis
     */
    @PostConstruct
    public void connect(){
        JedisPool pool = getJedisPool();
        try (Jedis jedis = pool.getResource()) {
            jedis.set("foo", "bar");
            logger.info("getting foo");
            logger.info(jedis.get("foo"));

            Map<String, String> hash = new HashMap<>();;
            hash.put("name", "Connie");
            hash.put("surname", "Zhang");
            hash.put("company", "IGS");
            hash.put("age", "32");
            jedis.hset("123", hash);

            p(jedis.hgetAll("123"));
        }
    }
    public String addBook(Book book) {
        JedisPooled jedis = getPooledJedis();
        String returnKey = String.valueOf(book.getId());
        jedis.hset(returnKey, book.convert());
        return returnKey;
    }
    public Book getBook(String key) {
        JedisPooled jedis = getPooledJedis();
        Map<String, String> bookMap = jedis.hgetAll(key);
        return Book.convert(bookMap);
    }
}
