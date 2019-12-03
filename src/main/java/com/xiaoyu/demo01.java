package com.xiaoyu;

import redis.clients.jedis.Jedis;

public class demo01 {
    public static void main(String[] args){

        //连接本地redis服务器
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("connection is OK==========>: "+jedis.ping());
    }
}
