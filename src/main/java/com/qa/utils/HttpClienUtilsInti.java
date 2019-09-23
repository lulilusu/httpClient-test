package com.qa.utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.qa.model.HttpClientRequest;
import com.qa.model.HttpClientResponse;

public class HttpClienUtilsInti {
	
	public void doGet() {
		
//		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpClient httpClient = HttpClienUtilsInti.createSSLClientDefault();
		
		HttpGet get = new HttpGet("https://test.360humi.com/api/homeCmsServer/getHomeCmsEmp?type=service1&_time=1568969197000&_sign=CJkDBkBCBgbbb");
		
		
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
	
	// 再次封装一个
	public HttpClientResponse doPost(HttpClientRequest request) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		String url = request.getUrl();
		HttpPost post = new HttpPost(url);
		// 设置头部json
		post.setHeader("Content-Type", "application/json");
		// 参数
		String strjson = "{'username':'admin','password':'1234'}";
		StringEntity entity = new StringEntity(strjson,"utf-8");	
		post.setEntity(entity);
		
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			response.getStatusLine().toString().split(" ");
			HttpEntity responseEntity = response.getEntity();
			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static CloseableHttpClient createSSLClientDefault() {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				
				public boolean isTrusted(X509Certificate[] chain,String authType) throws CertificateException{
					return true;
				}
			}).build();
			
			
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		
		return HttpClients.createDefault();
	}
	
	
	public static void main(String[] args) {
		new HttpClienUtilsInti().doGet();
	}
		
}
	
	
	
	
