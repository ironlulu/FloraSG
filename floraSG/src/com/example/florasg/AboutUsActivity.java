package com.example.florasg;

import com.example.florasg.R;
import com.example.florasg.R.layout;
import com.example.florasg.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AboutUsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_us, menu);
		return true;
	}

}
