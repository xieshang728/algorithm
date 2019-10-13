package org.yqb2c.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class DistributeLock {

    //一.redis为什么那么快
    //1.单线程，避免了线程上下文之间的切换，不需要考虑加锁造成的损耗
    //2.基于内存操作。
    //3.数据结构比较简单，像查找，操作的时间复杂度较小
    //4.使用了I/O多路复用模型，非阻塞IO

    public static final String REDIS_KEY = "lock:volcano";

    public Jedis getJedis(){
        return new Jedis("localhost",6379);
    }

    public void lock(){
        Jedis jedis = getJedis();

        if(jedis.setnx(REDIS_KEY,"true") == 1){
            //jedis.setex()
            //doSomething()
            //jedis.del()
        }else{

        }
    }
}
