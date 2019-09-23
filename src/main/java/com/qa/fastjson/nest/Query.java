package com.qa.fastjson.nest;

import java.util.LinkedHashMap;
import java.util.List;

public class Query {
   
	private String id;
	private String key;
	private String tableName;
	private String className;
	private List<LinkedHashMap<String, Object>> colum;
	private List<Colum> conlemList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<LinkedHashMap<String, Object>> getColum() {
		return colum;
	}
	public void setColum(List<LinkedHashMap<String, Object>> colum) {
		this.colum = colum;
	}
	public List<Colum> getConlemList() {
		return conlemList;
	}
	public void setConlemList(List<Colum> conlemList) {
		this.conlemList = conlemList;
	}
	
}
