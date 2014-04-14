package com.example.florasg;

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

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public URL getUrl() {
		return url;
	}
}
