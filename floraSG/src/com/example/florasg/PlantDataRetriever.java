package com.example.florasg;

import java.util.ArrayList;
import java.util.List;

public class PlantDataRetriever {
	
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
	
	//display sub-category glossary
	
	public String getGlossary(int subcategory_id){
		return new String("glossary");
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
