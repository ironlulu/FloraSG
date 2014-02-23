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

	public void testViewBookmark() {
		bmk.initTestCase1();
		boolean passed = false;
		List<ArrayList<String>> results1 = bmk.viewBookmark();
		if (results1.isEmpty()) {
			passed = true;
		}
		assertTrue(passed);
	}

	public void testDeleteBookmarks() {
		bmk.initTestCase2(5);
		boolean passed = false;
		List<ArrayList<String>> results2 = bmk.viewBookmark();
		if (results2.size() == 5) {
			passed = true;
		}
		assertTrue(passed);
	}

	public void testToggleBookmark() {
		bmk.deleteBookmarks(bmk.initTestCase3(5));
		boolean passed = false;
		List<ArrayList<String>> results3 = bmk.viewBookmark();
		if (results3.isEmpty()) {
			passed = true;
		}
		assertTrue(passed);
	}
}