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
		
		/*
		ArrayList<String> charList = intent.getStringArrayListExtra(SearchActivity.CHAR_LIST);

		String s = "";
		for(int i=0;i<charList.size();i++){
			s = s + charList.get(i);
			s = s+"/n";

		}
		*/
		
		//String s = "lalala";
		// Get the LayoutInflator service
		//LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// Use the inflater to inflate a stock row from stock_quote_row.xml
		//TextView searchResult = (TextView) inflater.inflate(R.id.searchResult, null);
		//searchResult.setText(s);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_result, menu);


		return true;
	}

}