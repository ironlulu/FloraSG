package com.example.florasg;

import java.util.ArrayList;
import java.util.List;

import android.test.ActivityInstrumentationTestCase2;

public class SearchElementRetrieverTester extends ActivityInstrumentationTestCase2<MainActivity> {
	
	SearchElementRetriever ser;
	
	public SearchElementRetrieverTester() {
		super (MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		ser=new SearchElementRetriever(mainActivity);
	}
	
	public void testGetAllCategory() {
		List<String> category=new ArrayList<String>();
		category=ser.getAllCategory();
		assertEquals("Correct category","Habit", category.get(0));
		assertEquals("Correct category","Leaf", category.get(1));
		assertEquals("Correct category","Flower", category.get(2));
		assertEquals("Correct category","Fruit", category.get(3));
		assertEquals("Correct category","Other", category.get(4));
	}

	public void testGetSubCategory() {
		List<String[]> subcategory= new ArrayList<String[]>();
		subcategory=ser.getSubCategory(5);
		assertEquals("Correct subcategory","Armed", subcategory.get(0)[1]);
		assertEquals("Correct subcategory","The small projections, usually in a pair, that are situated one on each side at the base of the stalk of a leaf. ", subcategory.get(1)[2]);
		assertEquals("Correct subcategory","Colour of sap", subcategory.get(2)[1]);
		assertEquals("Correct subcategory","The exposed surface from a cut made at right angle to the main axis of the plant stem. ", subcategory.get(3)[2]);
	}

	public void testGetDescription() {
		List<String[]> description= new ArrayList<String[]>();
		description=ser.getDescription(3);
		assertEquals("Correct description","Alternate or spiral", description.get(0)[1]);
		assertEquals("Correct description","Opposite", description.get(1)[1]);
		assertEquals("Correct description","Whorled", description.get(2)[1]);
	}

}
