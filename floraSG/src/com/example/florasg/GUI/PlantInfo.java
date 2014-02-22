package com.example.florasg.GUI;

import com.example.florasg.MainActivity;
import com.example.florasg.R;
import com.example.florasg.R.layout;
import com.example.florasg.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PlantInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plant_info);
		setTitle(MainActivity.plant);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plant_info, menu);
		return true;
	}

}
