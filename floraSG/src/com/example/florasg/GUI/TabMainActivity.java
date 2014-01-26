package com.example.florasg.GUI;

import com.example.florasg.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
 
@SuppressWarnings("deprecation")
public class TabMainActivity extends TabActivity implements OnTabChangeListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);
         
        TabHost tabHost = getTabHost();
        
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
        tabHost.addTab(searchspec); // Adding photos tab
        tabHost.addTab(browsespec); // Adding songs tab
        tabHost.addTab(cameraspec); // Adding videos tab
        tabHost.addTab(profilespec); // Adding photos tab
        tabHost.addTab(newsspec); // Adding songs tab
        
        // set Windows tab as default (zero based)
		tabHost.setCurrentTab(4);
    }

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		Log.i("Tab id", ""+tabId);
        setTitle(tabId);
	}
}