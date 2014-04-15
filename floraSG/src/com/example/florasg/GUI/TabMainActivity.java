package com.example.florasg.GUI;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

import com.example.florasg.AboutUsActivity;
import com.example.florasg.FaqActivity;
import com.example.florasg.R;
import com.example.florasg.SettingsActivity;
import com.example.florasg.UpdatesActivity;
import com.example.florasg.GUI.newsGUI.NewsActivity;
import com.example.florasg.GUI.profileGUI.ProfileActivity;
import com.example.florasg.GUI.searchGUI.SearchActivity;

@SuppressWarnings("deprecation")
public class TabMainActivity extends TabActivity implements OnTabChangeListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_main);

		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

		tabHost.setOnTabChangedListener(this);

		/** search Tab */
		TabSpec searchspec = tabHost.newTabSpec("Search");
		// setting Title and Icon for the Tab
		searchspec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_search));
		Intent searchIntent = new Intent(this, SearchActivity.class);
		searchspec.setContent(searchIntent);

		/** browse Tab */
		TabSpec browsespec = tabHost.newTabSpec("Browse");
		// setting Title and Icon for the Tab
		browsespec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_browse));
		Intent browseIntent = new Intent(this, BrowseActivity.class);
		browsespec.setContent(browseIntent);

		/** camera Tab */
		TabSpec cameraspec = tabHost.newTabSpec("Camera");
		// setting Title and Icon for the Tab
		cameraspec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_camera));
		Intent cameraIntent = new Intent(this, CameraActivity.class);
		cameraspec.setContent(cameraIntent);

		/** profile Tab */
		TabSpec profilespec = tabHost.newTabSpec("Profile");
		// setting Title and Icon for the Tab
		profilespec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_profile));
		Intent profileIntent = new Intent(this, ProfileActivity.class);
		profilespec.setContent(profileIntent);

		/** news Tab */
		TabSpec newsspec = tabHost.newTabSpec("News");
		// setting Title and Icon for the Tab
		newsspec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_news));
		Intent newsIntent = new Intent(this, NewsActivity.class);
		newsspec.setContent(newsIntent);

		// Adding all TabSpec to TabHost
		tabHost.addTab(searchspec); // Adding search tab
		tabHost.addTab(browsespec); // Adding browse tab
		tabHost.addTab(cameraspec); // Adding camera tab
		tabHost.addTab(profilespec); // Adding profile tab
		tabHost.addTab(newsspec); // Adding news tab

		// set Windows tab as default (zero based)
		tabHost.setCurrentTab(0);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_main, menu);
		return true;

		/*
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.tab_main, menu);
        MenuItem menuItem = menu.findItem(R.id.FAQ);
        ListView listView = (ListView) MenuItemCompat.getActionView(menuItem);

        // When using the support library, the setOnActionExpandListener() method is
        // static and accepts the MenuItem object as an argument
        MenuItemCompat.setOnActionExpandListener(menuItem, new OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed

                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        });

    	return true;
		 */
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		Log.i("Tab id", ""+tabId);
		setTitle(tabId);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_faq:
			Intent faqIntent = new Intent(this, FaqActivity.class);
			startActivity(faqIntent);
			return true;
		case R.id.action_aboutus:
			Intent aboutUsIntent = new Intent(this, AboutUsActivity.class);
			startActivity(aboutUsIntent);
			return true;
		case R.id.action_updates:
			Intent updatesIntent = new Intent(this, UpdatesActivity.class);
			startActivity(updatesIntent);
			return true;
		case R.id.action_settings:
			Intent settingsIntent = new Intent(this, SettingsActivity.class);
			startActivity(settingsIntent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
