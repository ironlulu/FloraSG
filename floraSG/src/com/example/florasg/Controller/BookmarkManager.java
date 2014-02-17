package com.example.florasg.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.florasg.DataBaseHelper;

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
	
	public boolean toggleBookmark(int species_id) {
		Cursor getBookmark;
		getBookmark = database.rawQuery("SELECT bookmark FROM species WHERE species_id = ?", new String[]{Integer.toString(species_id)});
		getBookmark.moveToFirst();
		String oriBookmark = getBookmark.getString(0);
		
		if (oriBookmark.equals("TRUE")) {
			database.execSQL("UPDATE species SET bookmark = ? WHERE species_id = ?", new String[]{"FALSE", Integer.toString(species_id)});
		}
		else {
			database.execSQL("UPDATE species SET bookmark = ? WHERE species_id = ?", new String[]{"TRUE", Integer.toString(species_id)});
		}
		
		Cursor afterToggle;
		afterToggle = database.rawQuery("SELECT bookmark FROM species WHERE species_id = ?", new String[]{Integer.toString(species_id)});
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
}
