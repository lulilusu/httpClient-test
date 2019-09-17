package com.qa.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClienUtils {
	
	public void doGet() {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://work.360humi.com");
		try {
			response = httpClient.execute(get);
			if(response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				String body = EntityUtils.toString(entity,"utf-8");
				System.out.println(body);
			}
			
	
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
	
	
	
	public static void main(String[] args) {
		new HttpClienUtils().doGet();
	}
	
	
	
}
