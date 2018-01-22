package bw.practise.ang.test;


import redis.clients.jedis.Jedis;

public class RedisTest {
	   public static void main(String[] args) {
		   Jedis jedis  = new Jedis();
		   jedis.set("uFancy","www.Fancy,com");
		   System.out.println("redis存储的字符串为："+jedis.get("uFancy"));
		   jedis.expire("uFancy", 5);
	}
}
