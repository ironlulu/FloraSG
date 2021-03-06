package com.example.florasg.Model;

import java.net.URL;
import java.util.Date;

public class News {

	private int news_ID;
	private String title;
	private String content;
	private Date date;
	private URL url;
	
	public News(int news_ID, String title, String content, Date date, URL url) {
		super();
		this.news_ID = news_ID;
		this.title = title;
		this.content = content;
		this.date = date;
		this.url = url;
	}

	public int getNews_ID() {
		return news_ID;
	}

	public void setNews_ID(int news_ID) {
		this.news_ID = news_ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
	
	
	
	
}
