package com.qa.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;

public class TestFastJson {

	// java����תΪjson�ַ���
	@Test
	public void objectTOJosn() {
		// java��תΪjson�ַ���
		User user = new User("zangsan", "123");
		String UserJson = JSON.toJSONString(user);
		System.out.println("java����תΪjson�ַ���:" +UserJson);
	
		//list<Object>תΪjson�ַ���
		User user1 = new User("lisi","1234");
		User user2 = new User("laowang","12345");
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		String ListUserJson = JSON.toJSONString(users);
		System.out.println("List<Object>��תΪjson�ַ���:" + ListUserJson);
		
		// ����java��תΪjson�ַ���
		UserGroup userGroup = new UserGroup("userGroup",users);
		String userGroupJson = JSON.toJSONString(userGroup);
		System.out.println("����java��תΪjson�ַ���:" + userGroupJson);
	}
	// json�ַ���תΪjava����
	@Test
	public void JsonTOObject() {
		/* json�ַ���ת��java����
         * �ַ�����{"password":"123456","username":"dmego"}*/
		String String1 = "{\"password\":\"123456\",\"username\":\"dmego\"}";
		User user = JSON.parseObject(String1,User.class);
		System.out.println("��json�ַ���תΪjava����" + user.toString());
		
		/*
         * json�ַ���תList<Object>����
         * �ַ�����[{"password":"123123","username":"zhangsan"},{"password":"321321","username":"lisi"}]
         */
		String string2 = "[{\"password\":\"123123\",\"username\":\"zhangsan\"},{\"password\":\"321321\",\"username\":\"lisi\"}]";
		List<User> users = JSON.parseArray(string2, User.class);
		System.out.println("json�ַ���תΪList<Object>��"+ users.toString());
	
		/*json�ַ���ת����java����
         * �ַ�����{"name":"userGroup","users":[{"password":"123123","username":"zhangsan"},{"password":"321321","username":"lisi"}]}
         * */
		String string3 = "{\"name\":\"userGroup\",\"users\":[{\"password\":\"123123\",\"username\":\"zhangsan\"},{\"password\":\"321321\",\"username\":\"lisi\"}]}";
		UserGroup userGroup = JSON.parseObject(string3, UserGroup.class);
		System.out.println("json�ַ���תΪ����java����" + userGroup.toString());
		
	}
}
