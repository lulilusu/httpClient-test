package com.qa.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;

public class TestFastJson {

	// java对象转为json字符串
	@Test
	public void objectTOJosn() {
		// java类转为json字符串
		User user = new User("zangsan", "123");
		String UserJson = JSON.toJSONString(user);
		System.out.println("java对象转为json字符串:" +UserJson);
	
		//list<Object>转为json字符串
		User user1 = new User("lisi","1234");
		User user2 = new User("laowang","12345");
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		String ListUserJson = JSON.toJSONString(users);
		System.out.println("List<Object>类转为json字符串:" + ListUserJson);
		
		// 负责java类转为json字符串
		UserGroup userGroup = new UserGroup("userGroup",users);
		String userGroupJson = JSON.toJSONString(userGroup);
		System.out.println("复杂java类转为json字符串:" + userGroupJson);
	}
	// json字符串转为java对象
	@Test
	public void JsonTOObject() {
		/* json字符串转简单java对象
         * 字符串：{"password":"123456","username":"dmego"}*/
		String String1 = "{\"password\":\"123456\",\"username\":\"dmego\"}";
		User user = JSON.parseObject(String1,User.class);
		System.out.println("简单json字符串转为java对象：" + user.toString());
		
		/*
         * json字符串转List<Object>对象
         * 字符串：[{"password":"123123","username":"zhangsan"},{"password":"321321","username":"lisi"}]
         */
		String string2 = "[{\"password\":\"123123\",\"username\":\"zhangsan\"},{\"password\":\"321321\",\"username\":\"lisi\"}]";
		List<User> users = JSON.parseArray(string2, User.class);
		System.out.println("json字符串转为List<Object>："+ users.toString());
	
		/*json字符串转复杂java对象
         * 字符串：{"name":"userGroup","users":[{"password":"123123","username":"zhangsan"},{"password":"321321","username":"lisi"}]}
         * */
		String string3 = "{\"name\":\"userGroup\",\"users\":[{\"password\":\"123123\",\"username\":\"zhangsan\"},{\"password\":\"321321\",\"username\":\"lisi\"}]}";
		UserGroup userGroup = JSON.parseObject(string3, UserGroup.class);
		System.out.println("json字符串转为复杂java对象：" + userGroup.toString());
		
	}
}
