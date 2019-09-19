package com.qa.model;

import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;

public class HttpClientRequest {
	
	private String url;
	private HttpUriRequest mothed;
	private Map<String, String> headers;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HttpUriRequest getMothed() {
		return mothed;
	}
	public void setMothed(HttpUriRequest mothed) {
		this.mothed = mothed;
	}
	public Map<String, String> getHaders() {
		return headers;
	}
	public void setHaders(Map<String, String> headers) {
		this.headers = headers;
	}

}
