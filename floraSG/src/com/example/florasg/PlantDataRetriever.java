package com.example.florasg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
		return new Plant(1, "speciesCode", "scientificName", "authorName", "commonName", "family", "description", "habitat", 5, 10, "distribution", "conservationStatus", "growthRequirement", "horticulturalFeatures", "uses", "associatedFauna", "reference", "TRUE");
	}
	
	//search by characteristics
	public List<Plant> searchPlantbyCharacteristics(List<Integer> description_id){
		//TODO: is ArrayList the way to do this?
		List<Plant> result=new ArrayList<Plant>();
		Cursor cursor;
		Plant p;
		
		int speciesID;
		String speciesCode;
		String scientificName;
		String authorName;
		String commonName;
		String family;
		String description;
		String habitat;
		int minLeafSize;
		int maxLeafSize;
		String distribution;
		String conservationStatus;
		String growthRequirement;
		String horticulturalFeatures;
		String uses;
		String associatedFauna;
		String reference;
		String bookmarkStatus;
		
		//construct a description count bucket table to tally characteristics matched
		cursor = database.rawQuery("SELECT species_id FROM species", null);
		int[] description_count=new int[cursor.getCount()];
		
		Iterator<Integer> iterator = description_id.iterator();
		while (iterator.hasNext()) {
			//System.out.println(iterator.next());
			cursor = database.rawQuery("SELECT species_id FROM species_description WHERE description_id= ?", new String[]{iterator.next().toString()});
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				  //+1 count for a particular species with matched characteristic  
			      description_count[(cursor.getInt(0)-1)]++;
			      cursor.moveToNext();
			}
		}
		
		boolean[] picked= new boolean[description_count.length];
		int highest_matched=0;
		int highest_matched_index=0;
		//find the top 10 result from the bucket array
		for (int i=0;i<10;i++){
			highest_matched=0;
			highest_matched_index=0;
			for(int j=0;j<description_count.length;j++){
				if(description_count[j]>highest_matched && !picked[j]){
					highest_matched=description_count[j];
					highest_matched_index=j;
				}
			}
			//marked it as picked
			picked[highest_matched_index]=true;
			//add the plant with the current highest matched characteristics to result list
			cursor=database.rawQuery("SELECT * FROM species WHERE species_id= ?", new String[]{Integer.toString(highest_matched_index+1)});
			cursor.moveToFirst();
			System.out.println("No. of column= "+cursor.getColumnCount());
			//get all the plant information to construct a plant object
			speciesID=cursor.getInt(16);
			speciesCode=cursor.getString(0);
			scientificName=cursor.getString(1);
			authorName=cursor.getString(2);
			commonName=cursor.getString(3);
			family=cursor.getString(4);
			description=cursor.getString(5);
			habitat=cursor.getString(6);
			minLeafSize=cursor.getInt(7);
			maxLeafSize=cursor.getInt(8);
			distribution=cursor.getString(9);
			conservationStatus=cursor.getString(10);
			growthRequirement=cursor.getString(11);
			horticulturalFeatures=cursor.getString(12);
			uses=cursor.getString(13);
			associatedFauna=cursor.getString(14);
			reference=cursor.getString(15);
			bookmarkStatus=cursor.getString(17);
			p=new Plant(speciesID,speciesCode,scientificName,authorName,commonName,family,
					description,habitat,minLeafSize,maxLeafSize, distribution, 
					conservationStatus,growthRequirement,horticulturalFeatures,uses,
					associatedFauna,reference,bookmarkStatus);
			result.add(p);
		}
		
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
