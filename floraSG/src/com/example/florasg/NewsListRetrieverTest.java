package com.example.florasg;

import java.util.List;

import android.test.ActivityInstrumentationTestCase2;

import com.example.florasg.Controller.NewsListRetriever;
import com.example.florasg.Model.News;

public class NewsListRetrieverTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private NewsListRetriever nlr;

	public NewsListRetrieverTest() {
		super (MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		nlr = new NewsListRetriever(mainActivity);
	}
	
	// can get all the news items from the database
	public void testCase1() {
		List<News> news = nlr.getLatestNews();
		boolean passed = false;
		if (news.size() == 4) { // modify this value according to database
			passed = true;
		}
		assertTrue(passed);
	}
	
	// can get desired news item
	public void testCase2() {
		int newsID = 1; // modify this value when needed
		News n = nlr.getNewsItem(newsID);
		boolean passed = false;
		if (n.getNews_ID() == newsID) {
			passed = true;
		}
		assertTrue(passed);
	}
}
