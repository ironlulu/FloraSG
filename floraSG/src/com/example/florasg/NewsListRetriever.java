package com.example.florasg;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class NewsListRetriever {
	private SQLiteDatabase database;
	private NewsDataBaseHelper dbHelper;
	
	public NewsListRetriever(Context context) {
		// open database for access
		dbHelper = new NewsDataBaseHelper(context);
		try {
			dbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
							  
		try { 
			dbHelper.openDataBase(); 
		} catch(SQLException sqle){  
			throw sqle;
		}
						
		database = dbHelper.getDatabase();
	}
	
	@SuppressWarnings("deprecation")
	public List<News> getLatestNews () {
		List<News> newsList = new ArrayList<News>();
		Cursor cursor;
		int news_ID;
		String title;
		String content;
		Date date;
		URL url = null;
		
		cursor = database.rawQuery("SELECT * FROM news ORDER BY date DESC", null);
		cursor.moveToFirst();
		int cursorSize = cursor.getCount();
		for (int i = 0; i < cursorSize; i++) {
			news_ID = cursor.getInt(0);
			title = cursor.getString(2);
			content = cursor.getString(3);
			date = Date.valueOf(cursor.getString(1));
			try {
				url = new URL(cursor.getString(4));
			} catch (MalformedURLException e) {
				Log.i("Error", "URL cannot be read");
			}
			newsList.add(new News(news_ID, title, content, date, url));
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return newsList;
	}
	
	@SuppressWarnings("deprecation")
	public News getNewsItem (int news_ID){
		Cursor cursor;
		String title;
		String content;
		Date date;
		URL url = null;
		
		cursor = database.rawQuery("SELECT * FROM news WHERE news_id = ?", new String[]{Integer.toString(news_ID)});
		cursor.moveToFirst();
		title = cursor.getString(2);
		content = cursor.getString(3);
		String[] temp = cursor.getString(1).split("-");
		date = new Date(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
		try {
			url = new URL(cursor.getString(4));
		} catch (MalformedURLException e) {
			Log.i("Error", "URL cannot be read");
		}
		
		return new News(news_ID, title, content, date, url);
	}
}
