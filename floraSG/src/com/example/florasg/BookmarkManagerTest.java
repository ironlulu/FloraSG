package com.example.florasg;

import java.util.ArrayList;
import java.util.List;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import junit.framework.TestCase;

public class BookmarkManagerTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private BookmarkManager bmk;
	
	public BookmarkManagerTest() {
		super (MainActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		bmk = new BookmarkManager(mainActivity);
	}

	// can view an empty list of bookmarks without crashing
	public void testCase1() {
		bmk.initTestCase1();
		boolean passed = false;
		List<ArrayList<String>> results1 = bmk.viewBookmark();
		if (results1.isEmpty()) {
			passed = true;
		}
		assertTrue(passed);
	}

	// can view n numbers of bookmarks where n = expected
	public void testCase2() {
		int expected = 5; // modify this value when needed
		bmk.initTestCase2(expected);
		boolean passed = false;
		List<ArrayList<String>> results2 = bmk.viewBookmark();
		if (results2.size() == expected) {
			passed = true;
		}
		assertTrue(passed);
	}

	// can delete n numbers of bookmarks where n = size
	public void testCase3() {
		int size = 5; // modify this value when needed
		List<Integer> speciesIDs = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			speciesIDs.add(i + 1);
		}
		bmk.deleteBookmarks(speciesIDs);
		boolean passed = false;
		List<ArrayList<String>> results3 = bmk.viewBookmark();
		if (results3.isEmpty()) {
			passed = true;
		}
		assertTrue(passed);
	}
}
