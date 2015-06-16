/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/
package redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * FIXME 类注释信息
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-05-25
 */
public class TestCase {
	/**
	 * 在不同的线程中使用相同的Jedis实例会发生奇怪的错误。但是创建太多的实现也不好因为这意味着会建立很多sokcet连接，
	 * 也会导致奇怪的错误发生。单一Jedis实例不是线程安全的。为了避免这些问题，可以使用JedisPool,
	 * JedisPool是一个线程安全的网络连接池。可以用JedisPool创建一些可靠Jedis实例，可以从池中拿到Jedis的实例。
	 * 这种方式可以解决那些问题并且会实现高效的性能
	 */

	public static void main(String[] args) {

		// ...when closing your application:
		// RedisUtil.getPool().destroy();
//		Hello();
		testList();
	}
	
	
	 public static void testList() {  
	        System.out.println("==List==");  
	        Jedis jedis = RedisUtil.getInstance().getJedis();  
	        try {  
	            // 开始前，先移除所有的内容  
	            jedis.del("messages");  
	            jedis.rpush("messages", "Hello how are you?");  
	            jedis.rpush("messages", "Fine thanks. I'm having fun with redis.");  
	            jedis.rpush("messages", "I should look into this NOSQL thing ASAP");  
	  
	            // 再取出所有数据jedis.lrange是按范围取出，  
	            // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有  
	            List<String> values = jedis.lrange("messages", 0, -1);  
	            System.out.println(values);  
	            // 清空数据  
		        System.out.println(jedis.flushDB());  
		        // 添加数据  
		        jedis.lpush("lists", "1");  
		        jedis.lpush("lists", "2");  
		        jedis.lpush("lists", "3");  
		        jedis.lpush("lists", "4");  
		        jedis.lpush("lists", "5");  
		        // 数组长度  
		        System.out.println(jedis.llen("lists"));  
		        // 排序  
//		        System.out.println(jedis.sort("lists"));  
		        // 字串  
		        System.out.println(jedis.lrange("lists", 0, -1));  
		        // 修改列表中单个值  
		        jedis.lset("lists", 0, "11");  
		        // 获取列表指定下标的值  
		        System.out.println(jedis.lindex("lists",0));  
		        // 删除列表指定下标的值  
		        System.out.println(jedis.lrem("lists", 1, "11s"));  
		         
		        // 删除区间以外的数据  
		        System.out.println(jedis.ltrim("lists", 0, 1));  
		       
		        // 列表出栈  
		        System.out.println(jedis.lpop("lists"));  
		        System.out.println(jedis.lrange("lists", 0, -1)); 
		        // 整个列表值  
		        System.out.println(jedis.lrange("lists", 0, -1));  
		        
		        jedis.rpush("ids", "aa");  
		        jedis.rpush("ids", "bb");  
		        jedis.rpush("ids", "cc");  
		  
		        List<String> ids = jedis.lrange("ids", 0, -1);  
		  
		        jedis.set("aa", "{'name':'zhoujie','age':20}");  
		        jedis.set("bb", "{'name':'yilin','age':28}");  
		        jedis.set("cc", "{'name':'lucy','age':21}");  
		        List<String> list = jedis.mget(ids.toArray(new String[ids.size()]));  
		        System.out.println(list);  
		        
		        
		       
		        jedis.sadd("zhongsou:tag:1:objects", 1000 + "");  
		        jedis.sadd("zhongsou:tag:2:objects", 1000 + "");  
		        jedis.sadd("zhongsou:tag:5:objects", 1000 + "");  
		        jedis.sadd("zhongsou:tag:77:objects", 1000 + "");  
		  
		        jedis.sadd("zhongsou:tag:1:objects", 3000 + "");  
		        jedis.sadd("zhongsou:tag:2:objects", 2000 + "");  
		        jedis.sadd("zhongsou:tag:5:objects", 2000 + "");  
		        jedis.sadd("zhongsou:tag:77:objects", 2000 + "");  
		  
		        Set<String> sets = jedis.sinter("zhongsou:tag:1:objects",  
		                "zhongsou:tag:2:objects", "zhongsou:tag:5:objects",  
		                "zhongsou:tag:77:objects");  
		        System.out.println(sets);
		        
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	        	RedisUtil.getInstance().closeJedis(jedis);
	        }  
	  
	      
	    }  
	 
	public static void Hello() {
		Jedis jedis = RedisUtil.getInstance().getJedis();
		try {
			// 向key-->name中放入了value-->minxr
			jedis.set("name", "minxr");
			String ss = jedis.get("name");
			System.out.println(ss);

			// 很直观，类似map 将jintao append到已经有的value之后
			jedis.append("name", "jintao");
			ss = jedis.get("name");
			System.out.println(ss);

			// 2、直接覆盖原来的数据
			jedis.set("name", "jintao");
			System.out.println(jedis.get("jintao"));

			// 删除key对应的记录
			jedis.del("name");
			System.out.println(jedis.get("name"));// 执行结果：null

			/**
			 * mset相当于 jedis.set("name","minxr"); jedis.set("jarorwar","aaa");
			 */
			jedis.mset("name", "minxr", "jarorwar", "aaa");
			System.out.println(jedis.mget("name", "jarorwar"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RedisUtil.getInstance().closeJedis(jedis);
		}
	}
}
