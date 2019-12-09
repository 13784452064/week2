package com.liyinghua.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liyinghua.beans.User;
import com.liyinghua.string.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:redis.xml")
public class addTest {
	@Autowired
	RedisTemplate rt;
/**
 * 	
 * @Title: addJDK 
 * @Description: jdk测试添加
 * @return: void
 */
	@Test
	public void addJDK() {
		User user = new User();
		long stare = System.currentTimeMillis();
		for (int i =1; i <=50000; i++) {
			user.setId(i);
			user.setName(StringUtil.getChineseName());
			user.setSex(StringUtil.getSex());
			user.setPhone(StringUtil.getPhoneNo());
			user.setEmail(StringUtil.getEmail(3, 20));
			user.setBirthday(StringUtil.getBirthday());
			rt.opsForValue().set("key"+i, user);
		}
		long end = System.currentTimeMillis();
		System.out.println("jdk方式共消耗"+(end-stare)+"ms");
		System.out.println("共有五万条数据");
	}
	/**
	 * 
	 * @Title: addJson 
	 * @Description: json测试添加
	 * @return: void
	 */
	@Test
	public void addJson() {
		User user = new User();
		long stare = System.currentTimeMillis();
		for (int i =1; i <=50000; i++) {
			user.setId(i);
			user.setName(StringUtil.getChineseName());
			user.setSex(StringUtil.getSex());
			user.setPhone(StringUtil.getPhoneNo());
			user.setEmail(StringUtil.getEmail(3, 20));
			user.setBirthday(StringUtil.getBirthday());
			rt.opsForValue().set("key"+i, user);
		}
		long end = System.currentTimeMillis();
		System.out.println("json方式共消耗"+(end-stare)+"ms");
		System.out.println("共有五万条数据");
	}
	/**
	 * 
	 * @Title: addHash 
	 * @Description: hash 测试添加
	 * @return: void
	 */
	@Test
	public void addHash() {
		User user = new User();
		long stare = System.currentTimeMillis();
		for (int i =1; i <=50000; i++) {
			user.setId(i);
			user.setName(StringUtil.getChineseName());
			user.setSex(StringUtil.getSex());
			user.setPhone(StringUtil.getPhoneNo());
			user.setEmail(StringUtil.getEmail(3, 20));
			user.setBirthday(StringUtil.getBirthday());
			rt.opsForHash().putIfAbsent("Key"+i, "key"+i, user.toString());
		}
		long end = System.currentTimeMillis();
		System.out.println("hash方式共消耗"+(end-stare)+"ms");
		System.out.println("共有五万条数据");
	}
}
