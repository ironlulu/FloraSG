package com.example.florasg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SearchElementRetriever {
	private SQLiteDatabase database;
	private DataBaseHelper dbHelper;
	private List<String> category;
	
	public SearchElementRetriever (Context context) {
		dbHelper = new DataBaseHelper(context);
		category=new ArrayList<String>();
	}
	
	//open the DB or create the DB if it doesn't exist
	public void openDB(){
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
			
			database=dbHelper.getDatabase();
	}
	
	//get all category
	public List<String> getAllCategory(){
		Cursor cursor = database.rawQuery("SELECT category_name FROM category",null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			 category.add(cursor.getString(0));
			 cursor.moveToNext();
	    }
	// make sure to close the cursor
		cursor.close();
		return category;
	}
	
	//get subcategory
	public List<String[]> getSubCategory(int category_id){
		List<String[]> subcategory= new ArrayList<String[]>();
		Cursor cursor = database.rawQuery("SELECT subcategory_name, Glossary FROM subcategory WHERE category_id= ?", new String[]{Integer.toString(category_id)});
		cursor.moveToFirst();
		String[] subcategory_element=new String[2];
		while (!cursor.isAfterLast()) {
			subcategory_element[0]=cursor.getString(0);
			subcategory_element[1]=cursor.getString(1);
			subcategory.add(subcategory_element);
			cursor.moveToNext();
	    }
	// make sure to close the cursor
		cursor.close();
		return subcategory;
	}
	
	//get description
	public List<String[]> getDescription(int subcategory_id){
		List<String[]> description= new ArrayList<String[]>();
		String[] description_element=new String[3];
		Cursor cursor = database.rawQuery("SELECT description_id, description_name, description_image FROM description WHERE subcategory_id= ?", new String[]{Integer.toString(subcategory_id)});
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			 description_element[0]=cursor.getString(0);
			 description_element[1]=cursor.getString(1);
			 description_element[2]=cursor.getString(2).toLowerCase();
			 description.add(description_element);
			 cursor.moveToNext();
	    }
		// make sure to close the cursor
		cursor.close();
		return description;
	}
}
