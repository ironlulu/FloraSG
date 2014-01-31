package com.example.florasg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class PlantDataRetriever {
	
	private SQLiteDatabase database;
	private DataBaseHelper dbHelper;
	private List<String> glossary;
	
	public PlantDataRetriever (Context context) {
		dbHelper = new DataBaseHelper(context);
		glossary=new ArrayList<String>();
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
	
	//display plant info page
	public Plant getPlant(int species_id){
		return new Plant(1, "scientificName", "commonName", "family", "description", "habitat", 5, 10, "distribution", "conservationStatus", "growthRequirement", "horticulturalFeatures", "uses", "associatedFauna", false);
	}
	
	//search by characteristics
	public List<Plant> searchPlantbyCharacteristics(List<Integer> description_id){
		//TODO: is ArrayList the way to do this?
		List<Plant> result=new ArrayList<Plant>();
		return result;
	}
	
	//sort search result
	public List<Plant> sortResult(List<Plant> result){
		return result;
	}
	
	//get all glossary to memory
	public void getAllGlossary(){
		Cursor cursor = database.rawQuery("SELECT Glossary FROM subcategory",null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
		      glossary.add(cursor.getString(0));
		      cursor.moveToNext();
		    }
		    // make sure to close the cursor
		cursor.close();
	}
	
	//display sub-category glossary
	public String getGlossary(int subcategory_id){
		return glossary.get(subcategory_id-1);
	}
	
	//browse plant
	public List<Plant> browsePlant(int browsing_mode){
		//TODO: is ArrayList the way to do this?
		List<Plant> all_plant=new ArrayList<Plant>();
		return all_plant;
	}
	
	//search plant by keyword
	public List<Plant> searchPlantbyKeyword(String keyword){
		//TODO: is ArrayList the way to do this?
		List<Plant> result=new ArrayList<Plant>();
		return result;
	}

}
