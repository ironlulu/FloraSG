package com.example.florasg;


import com.example.florasg.GUI.TabMainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	public static String plant;  //The plant that user select to view detailed info
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting);
		
		//SearchElementRetriever ser = new SearchElementRetriever(this);
		//ArrayList<String> categoryList = (ArrayList<String>) ser.getAllCategory();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.starting, menu);
		return true;
	}

	public void goIntoApp(View view) {
		Intent intent = new Intent(this, TabMainActivity.class);    
		startActivity(intent);
		//A comment here
		// I add another comment :3
	}


}
