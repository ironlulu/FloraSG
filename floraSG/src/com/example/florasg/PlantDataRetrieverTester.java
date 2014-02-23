package com.example.florasg;

import android.test.ActivityInstrumentationTestCase2;

public class PlantDataRetrieverTester extends ActivityInstrumentationTestCase2<MainActivity> {
	
	PlantDataRetriever pdr;
	
	//private TextView result;
	@SuppressWarnings("deprecation")
	public PlantDataRetrieverTester() {
	super ("com.example.florasg", MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		pdr=new PlantDataRetriever(mainActivity);
		//result = (TextView) mainActivity.findViewById(R.id.result);
	}

	public void testGetPlant() {
		Plant p= pdr.getPlant("Ardisia crenata");
		assertEquals("Correct plant","Ardisia crenata", p.getSciName());
		//fail("Not yet implemented");
	}

	public void testSearchPlantbyCharacteristics() {
		fail("Not yet implemented");
	}

}
