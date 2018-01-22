package bw.practise.ang.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bw.practise.ang.bean.Member;
import bw.practise.ang.util.ObjectSer;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RankingTest {
	
	private ClassPathXmlApplicationContext context;
	private ShardedJedisPool shardedJedisPool;  
	private ShardedJedis jedis;  
	  
	public RankingTest() {  
	  
	}  
	  
	@Before  
	public void init() throws Exception {  
	  
        String config[] = {"config/applicationContext-Redis.xml" };  
        context = new ClassPathXmlApplicationContext(config);  
  
        shardedJedisPool = (ShardedJedisPool) context.getBean("shardedJedisPool");  
        jedis = (ShardedJedis) shardedJedisPool.getResource();  
          
    }  
	   @Test  
	   @Ignore  
	   public void rankAdd() {  
	        Member user1 = new Member("12345", "常少鹏", 99.9);  
	        Member user2 = new Member("12346", "王卓卓", 99.8);  
	        Member user3 = new Member("12347", "邹雨欣", 96.8);  
	        Member user4 = new Member("12348", "郑伟山", 98.8);  
	        Member user5 = new Member("12349", "李超杰", 99.6);  
	        Member user6 = new Member("12350", "董明明", 99.0);  
	        Member user7 = new Member("12351", "陈国峰", 100.0);  
	        Member user8 = new Member("12352", "楚晓丽", 99.6);  
	        jedis.zadd("game".getBytes(), user1.getScore(), ObjectSer.ObjectToByte(user1));  
	        jedis.zadd("game".getBytes(), user2.getScore(), ObjectSer.ObjectToByte(user2));  
	        jedis.zadd("game".getBytes(), user3.getScore(), ObjectSer.ObjectToByte(user3));  
	        jedis.zadd("game".getBytes(), user4.getScore(), ObjectSer.ObjectToByte(user4));  
	        jedis.zadd("game".getBytes(), user5.getScore(), ObjectSer.ObjectToByte(user5));  
	        jedis.zadd("game".getBytes(), user6.getScore(), ObjectSer.ObjectToByte(user6));  
	        jedis.zadd("game".getBytes(), user7.getScore(), ObjectSer.ObjectToByte(user7));  
	        jedis.zadd("game".getBytes(), user8.getScore(), ObjectSer.ObjectToByte(user8));  
	    }  
	          
	    @Test  
	    //@Ignore  
	    public void gameRankShow() {  
	        Set<byte[]> set = jedis.zrevrange("game".getBytes(), 0, -1);  
	        Iterator<byte[]> iter = set.iterator();  
	      
	        int i = 1;  
	        List<Member> list = new ArrayList<Member>();  
	        while(iter.hasNext()) {  
	        	Member user = (Member) ObjectSer.ByteToObject(iter.next());  
	            user.setRank(i++);  
	            list.add(user);  
	        }  
	          
	        for(Member user : list)   
	            System.out.println(user);  
	    }  
	      
	
}
