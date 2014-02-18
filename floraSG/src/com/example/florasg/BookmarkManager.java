package com.example.florasg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BookmarkManager {
	private SQLiteDatabase database;
	private DataBaseHelper dbHelper;
	private List<ArrayList<String>> bookmarked_plants;

	public BookmarkManager(Context context) {
		dbHelper = new DataBaseHelper(context);
		bookmarked_plants = new ArrayList<ArrayList<String>>();
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
	
	public boolean toggleBookmark(String scientific_name) {
		Cursor getBookmark;
		getBookmark = database.rawQuery("SELECT bookmark FROM species WHERE scientific_name = ?", new String[]{scientific_name});
		getBookmark.moveToFirst();
		String oriBookmark = getBookmark.getString(0);
		
		if (oriBookmark.equals("TRUE")) {
			database.execSQL("UPDATE species SET bookmark = ? WHERE scientific_name = ?", new String[]{"FALSE", scientific_name});
		}
		else {
			database.execSQL("UPDATE species SET bookmark = ? WHERE scientific_name = ?", new String[]{"TRUE", scientific_name});
		}
		
		Cursor afterToggle;
		afterToggle = database.rawQuery("SELECT bookmark FROM species WHERE scientific_name = ?", new String[]{scientific_name});
		afterToggle.moveToFirst();
		String newStatus = afterToggle.getString(0);
		
		if (newStatus.equals(oriBookmark)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public List<ArrayList<String>> viewBookmark() {
		Cursor cursor;
		ArrayList<String> p;
		String speciesCode;
		String scientificName;
		
		//database.execSQL("UPDATE species SET bookmark = ?", new String[]{"FALSE"});
		cursor = database.rawQuery("SELECT species_code, scientific_name FROM species WHERE bookmark = ?", new String[]{"TRUE"});
		cursor.moveToFirst();
		int cursorSize = cursor.getCount();
		for (int i = 0; i < cursorSize; i++) {
			speciesCode = cursor.getString(0);
			scientificName = cursor.getString(1);
			p = new ArrayList<String>();
			p.add(speciesCode);
			p.add(scientificName);
			bookmarked_plants.add(p);
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return bookmarked_plants;
	}
	
	public void deleteBookmarks(List<String> plantsToBeUnbookmarked) {
		int size = plantsToBeUnbookmarked.size();
		for (int i = 0; i < size; i++) {
			while (!toggleBookmark(plantsToBeUnbookmarked.get(i))) {
				continue;
			}
		}
	}
}
