package com.qa.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClienUtilsInti {
	
	public void doGet() {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://work.360humi.com");
		
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(get);
		
				HttpEntity entity = response.getEntity();
				String body = EntityUtils.toString(entity,"utf-8");
				System.out.println(body);
			
			
	
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	}
	
	public void dePost() {
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://gateway.360humi.com/security/authentication/form");
		post.setHeader("Content-Type", "application/json;charset=utf8");
		String strjson = "{'username':'admin','password':'1234'}";
		StringEntity entity = new StringEntity(strjson,"utf-8");	
		post.setEntity(entity);
		
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(post);
			HttpEntity responseEntity = response.getEntity();
			if(responseEntity != null) {
				System.out.println(EntityUtils.toString(responseEntity,"utf-8")); 
				System.out.println(response.getStatusLine().getStatusCode());
			}
				
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(httpClient != null) httpClient.close();
				if(response != null) response.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		new HttpClienUtilsInti().dePost();
	}
		
}
	
	
	
	
