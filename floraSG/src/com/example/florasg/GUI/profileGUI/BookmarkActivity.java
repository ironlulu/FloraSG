package com.example.florasg.GUI.profileGUI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BookmarkActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textview = new TextView(this);
        textview.setText("Bookmark List!");
        setContentView(textview);
	}




}
