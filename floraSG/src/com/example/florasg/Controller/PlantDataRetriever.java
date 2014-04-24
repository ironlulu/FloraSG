
package com.example.florasg.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.florasg.DataBaseHelper;
import com.example.florasg.Model.Plant;


public class PlantDataRetriever {
	
	private SQLiteDatabase database;
	private DataBaseHelper dbHelper;
	
	public PlantDataRetriever (Context context) {
		dbHelper = new DataBaseHelper(context);
		openDB();
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
	
	//display plant info page by getting a plant object by its scientific name
	public Plant getPlant(String scientific_name){
		int speciesID;
		String speciesCode;
		String authorName;
		String commonName;
		String scientificName;
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
		
		Plant p;
		
		Cursor cursor;
		cursor=database.rawQuery("SELECT * FROM species WHERE scientific_name= ?", new String[]{scientific_name});
		cursor.moveToFirst();
		//System.out.println("No. of column= "+cursor.getColumnCount());
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
		/*return new Plant(speciesID,speciesCode,scientificName,authorName,commonName,family,
				description,habitat,minLeafSize,maxLeafSize, distribution, 
				conservationStatus,growthRequirement,horticulturalFeatures,uses,
				associatedFauna,reference,bookmarkStatus);*/
		p=new Plant(speciesID, speciesCode, scientificName);
		p.setAuthorName(authorName);
		p.setComName(commonName);
		p.setFamily(family);
		p.setDescription(description);
		p.setHabitat(habitat);
		p.setMinLeafSize(minLeafSize);
		p.setMaxLeafSize(maxLeafSize);
		p.setDistribution(distribution);
		p.setConservationStatus(conservationStatus);
		p.setGrowthReq(growthRequirement);
		p.setHorticulturalFeatures(horticulturalFeatures);
		p.setUses(uses);
		p.setAssociatedFauna(associatedFauna);
		p.setReference(reference);
		p.setBookmarkStatus(bookmarkStatus);
		
		return p;
		
	}
	
	//search by characteristics
	public List<String[]> searchPlantbyCharacteristics(List<Integer> description_id){
		List<String[]> result=new ArrayList<String[]>();
		Cursor cursor;
		
		String speciesCode;
		String scientificName;
		String commonName;
		
		/*construct a description count bucket table to tally characteristics matched
		for each plant*/
		cursor = database.rawQuery("SELECT species_id FROM species", null);
		int[] description_count=new int[cursor.getCount()];
		
		Iterator<Integer> iterator = description_id.iterator();
		while (iterator.hasNext()) {
			cursor = database.rawQuery("SELECT species_id FROM species_description WHERE description_id= ?", new String[]{iterator.next().toString()});
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				  //+1 count for a particular species with matched characteristic  
			      description_count[(cursor.getInt(0)-1)]++;
			      cursor.moveToNext();
			}
		}
		
		/*count the number of plant to be picked to display 
		(plants with at least 1 characteristic matched)*/
		int search_count=0;
		for(int i=0;i<description_count.length;i++){
			if(description_count[i]>0){
				search_count++;
			}
		}
		
		boolean[] picked= new boolean[description_count.length];
		int highest_matched=0; //no. of characteristics matched
		int highest_matched_index=0; //keep the index of plant with highest characteristics matched
		//find the result from the bucket array
		for (int i=0;i<search_count;i++){
			highest_matched=0;
			highest_matched_index=0;
			for(int j=0;j<description_count.length;j++){
				if(description_count[j]>highest_matched && !picked[j]){
					highest_matched=description_count[j];
					highest_matched_index=j;
				}
			}
			System.out.println("Characteristics Matched: "+highest_matched);
			//marked it as picked
			picked[highest_matched_index]=true;
			//add the plant with the current highest matched characteristics to result list
			cursor=database.rawQuery("SELECT species_code, scientific_name, common_name FROM species WHERE species_id= ?", new String[]{Integer.toString(highest_matched_index+1)});
			cursor.moveToFirst();
			System.out.println("No. of column= "+cursor.getColumnCount());
			//get plant information to pass to GUI 
			speciesCode=cursor.getString(0);
			scientificName=cursor.getString(1);
			commonName=cursor.getString(2);
			String[] plantParticular= new String[4];
			plantParticular[0]=speciesCode.toLowerCase();
			plantParticular[1]=scientificName;
			plantParticular[2]=commonName;
			plantParticular[3]=Integer.toString(highest_matched);
			result.add(plantParticular);
		}
		return result;
	}
	
	//browse plant
		@SuppressWarnings("null")
		public List<String> browsePlant(int browsing_mode){
			List<String> all_plant=new ArrayList<String>();
			Cursor cursor=null;
			/*construct a description count bucket table to tally characteristics matched
			for each plant*/
			switch (browsing_mode){
			
			case 1:
				cursor=database.rawQuery("SELECT scientific_name FROM species ORDER BY scientific_name ASC", null);
				break;
			case 2:
				cursor=database.rawQuery("SELECT common_name FROM species ORDER BY common_name ASC", null);
				break;
			case 3:
				cursor=database.rawQuery("SELECT family_name FROM species ORDER BY family_name ASC", null);
				break;
			default:
				System.out.println("No such browsing option");
				break;
			}
			
				cursor.moveToFirst();
				System.out.println("No. of column= "+cursor.getColumnCount());
				
				String plantNameParticular=null;
				
				while (!cursor.isAfterLast()) {
				//get plant name information to pass to GUI 
				
				plantNameParticular=cursor.getString(0);//scientificName
				all_plant.add(plantNameParticular);
				cursor.moveToNext();
			    }
		    cursor.close();
			return all_plant;
		}
		
		//search plant by keyword (the keyword is any parts of the scientific name or common name or family name)
		public List<ArrayList<String>> searchPlantbyKeyword(String keyword){
			List<ArrayList<String>> searchResult=new ArrayList<ArrayList<String>>();
			ArrayList<String> p;
			Cursor cursor;
			String speciesCode;
			String scientificName;
			String commonName;
			String familyName;

			cursor=database.rawQuery("SELECT * FROM species WHERE scientific_name LIKE '%?' OR common_name LIKE '%?' OR family_name LIKE '%?'", new String[]{keyword});
			cursor.moveToFirst();
			System.out.println("No. of column= "+cursor.getColumnCount());
			int cursorSize = cursor.getCount();
			
			//get plant name information to pass to GUI
			for (int i = 0; i < cursorSize; i++) {
				speciesCode = cursor.getString(0).toLowerCase();
				scientificName = cursor.getString(1);
				commonName=cursor.getString(2);
				familyName=cursor.getString(4);
				p = new ArrayList<String>();
				p.add(speciesCode);
				p.add(scientificName);
				searchResult.add(p);
				cursor.moveToNext();
			}
	        cursor.close();
			return searchResult;
		}

}
