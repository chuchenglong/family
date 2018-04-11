package com.mc.family.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenglongChu
 * @description
 * @create 2018/02/02 15:03
 */
public class TestRedis {
    private static String ADDR = "127.0.0.1";
    // Redis的端口号
    private static int PORT = 6379;
    // 访问密码
    private static String AUTH = "admin";
    // 可用连接实例的最大数目, 默认值为8
    // 如果赋值为-1, 则表示不限制
    // 如果pool已经分配了maxActive个jedis实例, 则此时pool的状态为exhausted(耗尽)
    private static int MAX_ACTIVE = 1024;
    // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例, 默认值也是8
    private static int MAX_IDLE = 200;
    // 等待可用连接的最大时间, 单位毫秒, 默认值为-1, 表示永不超时
    // 如果超过等待时间, 则直接抛出JedisConnectionException
    private static int MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;
    // 在borrow一个jedis实例时, 是否提前进行validate操作
    // 如果为true, 则得到的jedis实例均是可用的
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取Jedis实例
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 释放jedis资源
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

    public void testString() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        jedis.auth("admin");
//        jedis.set("name", "chuxiaoran");
        System.out.println(jedis.get("name"));
    }

    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "qqqq");
        map.put("age", "23");
        map.put("ppp", "kkkk");
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.hmset("user", map);

        List<String> rsmap = jedis.hmget("user","name","age","ppp");
        System.out.println(rsmap);

        jedis.hdel("user", "age");
        System.out.println(jedis.hmget("user", "age")); // 因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); // 返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user")); // 是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user")); // 返回map对象中的所有key
        System.out.println(jedis.hvals("user")); // 返回map对象中的所有value
    }

    public static void main(String[] args) {
        TestRedis t = new TestRedis();
        t.testMap();
    }

}
