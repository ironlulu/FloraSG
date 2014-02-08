package com.example.florasg.GUI.searchGUI;

import java.util.ArrayList;

import com.example.florasg.R;
import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class SearchActivity extends TabActivity implements OnTabChangeListener {
	
	public static String categoryName;
	public static ArrayList<String> categoryList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		categoryList = new ArrayList<String>();
		
		//Test data
		categoryList.add("Habit");
		categoryList.add("Leaf");
		categoryList.add("Flower");
		categoryList.add("Fruit");
		categoryList.add("Other");
		int size = categoryList.size();
		
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setOnTabChangedListener(this);
		
		for (int i=0;i<size;i++){
			String category = categoryList.get(i);
			Intent newIntent = new Intent().setClass(this, SelectCharActivity.class);
			TabSpec newSpec = tabHost
					  .newTabSpec(category)
					  .setIndicator(category)
					  .setContent(newIntent);
			tabHost.addTab(newSpec);
		}
		tabHost.setCurrentTab(0);
		categoryName = categoryList.get(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		Log.i("Tab id", ""+tabId);
        categoryName = tabId;
        //Log.i("Category Name", ""+categoryName);
	}

}
