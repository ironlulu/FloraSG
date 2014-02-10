package com.example.florasg.GUI.searchGUI;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TextView;

import com.example.florasg.R;

public class SearchResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);
	
		Intent intent = getIntent();		
		ArrayList<String> charList = intent.getStringArrayListExtra(SearchActivity.CHAR_LIST);

		//Print out the checked characteristics for testing
		String s = "";
		for(int i=0;i<charList.size();i++){
			s = s + charList.get(i);
			s = s+"\n";

		}
		
		TextView searchResult = (TextView) findViewById(R.id.searchResult);
		searchResult.setText(s);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_result, menu);


		return true;
	}

}
