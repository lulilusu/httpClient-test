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
	 * 读取路径下的配置文件 并存为数组返回
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Query> test() throws IOException {
		// 读取路径下的query.json文件
		ClassLoader cl = this.getClass().getClassLoader();
		InputStream inputStrem = cl.getResourceAsStream("query.json");
		String jsonText = IOUtils.toString(inputStrem);
		// 将字符json串转为数组
		List<Query> queryList = JSON.parseArray(jsonText, Query.class);
		for (Query query : queryList) {
			List<Colum> columList = new ArrayList<Colum>();
			List<LinkedHashMap<String, Object>> colums = query.getColum();
			for (LinkedHashMap<String, Object> linkedList : colums) {
				// 将map转为实体类
				Colum colum = (Colum) mapTOObject(linkedList, Colum.class);
				System.out.println(colum.toString());
				columList.add(colum);
			}
			query.setConlemList(columList); // 赋值ConlemList
		}
		return queryList;
	}

	/**
	 * Map转为实体对象
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
