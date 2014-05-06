package com.example.florasg.Model;

import java.net.URL;

public class Blog {
	String blogName;
	URL url;
	
	public Blog(String name, URL url){
		this.blogName = name;
		this.url = url;
	}
	
	public String getName(){
		return blogName;
	}
	
	public URL getURL () {
		return url;
	}

}
