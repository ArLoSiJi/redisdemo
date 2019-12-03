package com.xiaoyu;

import redis.clients.jedis.Jedis;

import java.security.KeyStore;
import java.util.*;

public class Test01 {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //key
        Set<String> keys = jedis.keys("*");

      /*  for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            System.out.println(key);
        }

        System.out.println("jedis.exists====>"+jedis.exists("k1"));
        System.out.println("jedis.ttl"+jedis.ttl("k2"));

        System.out.println(jedis.get("k2"));

        System.out.println(jedis.set("k5","laosijit"));

        System.out.println("------------------------------");

        System.out.println(jedis.mset("str1","s1","str2","s2","str3","s3"));
*/
        //liset
        //System.out.println(jedis.lpush("mylist","l1","l2","l3","l4"));

        List<String> mylist = jedis.lrange("mylist", 0, -1);

        for (String s : mylist) {

            System.out.println(s);
        }

        System.out.println("------------------------");

        //set
        jedis.sadd("set01", "001");
        jedis.sadd("set01", "002");
        jedis.sadd("set01", "003");

        Set<String> set01 = jedis.smembers("set01");
        for (Iterator<String> iterator = set01.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            System.out.println(next);
        }
        //删除一个vlue
        jedis.srem("set01", "001");
        //判断key里有没有这个值并返回它的长度
        System.out.println(jedis.smembers("set01").size());

        System.out.println("hash---------------------------");
        //hash
        jedis.hset("hash01", "userName", "laosiji");

        System.out.println(jedis.hget("hash01", "userName"));

        Map<String, String> map = new HashMap<String, String>();

        map.put("telphone", "142315235135");
        map.put("address", "atguigu");
        map.put("email", "abc@163.com");
        jedis.hmset("hset02", map);
        List<String> hmget = jedis.hmget("hset02", "telphone", "address");
        for (String s : hmget) {
            System.out.println(s);
        }
        //zset
        System.out.println("zset========================");

        jedis.zadd("zset01", 60d, "v1");
        jedis.zadd("zset01", 70d, "v2");
        jedis.zadd("zset01", 80d, "v3");
        jedis.zadd("zset01", 90d, "v4");
        Set<String> zset01 = jedis.zrange("zset01", 1, -1);
        for (Iterator<String> iterator = zset01.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            System.out.println(next);
        }


    }


}
