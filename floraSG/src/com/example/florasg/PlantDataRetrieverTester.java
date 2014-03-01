package com.example.florasg;

import java.util.ArrayList;
import java.util.List;

import android.test.ActivityInstrumentationTestCase2;

import com.example.florasg.Controller.PlantDataRetriever;
import com.example.florasg.Model.Plant;

public class PlantDataRetrieverTester extends ActivityInstrumentationTestCase2<MainActivity> {
	
	PlantDataRetriever pdr;
	
	public PlantDataRetrieverTester() {
		super (MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		pdr=new PlantDataRetriever(mainActivity);
	}

	public void testGetPlant() {
		Plant p1= pdr.getPlant("Ardisia crenata");
		Plant p2= pdr.getPlant("Zoysia matrella");
		assertEquals("Correct plant p1","Ardisia crenata", p1.getSciName());
		assertEquals("Correct plant p2", "ZOYMAT", p2.getSpeciesCode());
	}

	public void testSearchPlantbyCharacteristics() {
		List<Integer>description_id=new ArrayList<Integer>();
		description_id.add(2);
    	description_id.add(77);
    	description_id.add(30);
		List<String[]> search_result=pdr.searchPlantbyCharacteristics(description_id);
		assertEquals("Correct species", "Ardisia crenata", search_result.get(0)[1]);
		assertEquals("Correct species", "Fagraea auriculata", search_result.get(3)[1]);
		assertEquals("Correct species", "Common tree-vine, jolok-jolok, merbati padang", search_result.get(6)[2]);
	}

}
