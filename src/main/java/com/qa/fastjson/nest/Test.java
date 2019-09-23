package com.qa.fastjson.nest;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

public class Test {
	/**
	 * ��ȡ·���µ������ļ� ����Ϊ���鷵��
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Query> test() throws IOException {
		// ��ȡ·���µ�query.json�ļ�
		ClassLoader cl = this.getClass().getClassLoader();
		InputStream inputStrem = cl.getResourceAsStream("query.json");
		String jsonText = IOUtils.toString(inputStrem);
		// ���ַ�json��תΪ����
		List<Query> queryList = JSON.parseArray(jsonText, Query.class);
		for (Query query : queryList) {
			List<Colum> columList = new ArrayList<Colum>();
			List<LinkedHashMap<String, Object>> colums = query.getColum();
			for (LinkedHashMap<String, Object> linkedList : colums) {
				// ��mapתΪʵ����
				Colum colum = (Colum) mapTOObject(linkedList, Colum.class);
				System.out.println(colum.toString());
				columList.add(colum);
			}
			query.setConlemList(columList); // ��ֵConlemList
		}
		return queryList;
	}

	/**
	 * MapתΪʵ�����
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static Object mapTOObject(Map<String, Object> map, Class clazz) {
		if (map != null) {
			return null;
		}
		Object obj = null;
		try {
			obj = clazz.newInstance();
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				int mod = field.getModifiers();
				if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
					continue;
				}
				field.setAccessible(true);
				String falg = (String) map.get(field.getName());
				if (falg != null) {
					if (falg.equals("false") || falg.equals("true")) {
						field.set(obj, Boolean.parseBoolean(falg));
					} else {
						field.set(obj, map.get(field.getName()));
					}
				}
			}

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;

	}
}
