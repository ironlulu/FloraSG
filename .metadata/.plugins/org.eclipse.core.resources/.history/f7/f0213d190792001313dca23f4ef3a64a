package com.example.florasg.GUI.profileGUI;

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
public class ProfileActivity extends TabActivity implements OnTabChangeListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        
        tabHost.setOnTabChangedListener(this);
         
        /** bookmark Tab */
        TabSpec bookmarkspec = tabHost.newTabSpec("Bookmark");
        // setting Title and Icon for the Tab
        bookmarkspec.setIndicator("Bookmark");
        Intent bookmarkIntent = new Intent(this, BookmarkActivity.class);
        bookmarkspec.setContent(bookmarkIntent);
         
        /** photo Tab */
        TabSpec photospec = tabHost.newTabSpec("Photo");
        // setting Title and Icon for the Tab
        photospec.setIndicator("Photo");
        Intent photoIntent = new Intent(this, PhotoActivity.class);
        photospec.setContent(photoIntent);
        
        /** map Tab */
        TabSpec mapspec = tabHost.newTabSpec("Map");
        // setting Title and Icon for the Tab
        mapspec.setIndicator("Map");
        Intent mapIntent = new Intent(this, MapActivity.class);
        mapspec.setContent(mapIntent);
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(bookmarkspec); // Adding bookmark tab
        tabHost.addTab(photospec); // Adding photo tab
        tabHost.addTab(mapspec); // Adding map tab

        // set Windows tab as default (zero based)
		tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		Log.i("Tab id", ""+tabId);
        setTitle(tabId);
	}

}
