package com.example.florasg.GUI.profileGUI;

import java.util.ArrayList;
import java.util.List;

import com.example.florasg.MainActivity;
import com.example.florasg.R;
import com.example.florasg.Controller.BookmarkManager;
import com.example.florasg.GUI.PlantInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

public class BookmarkActivity extends Activity {
	
	private TableLayout bookmarkTable;
	private List<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();
	BookmarkManager bm;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_bookmark);
				
		/*
		for (int i=0; i<10;i++){
			ArrayList<String> list = new ArrayList<String>();
			list.add("img"+i);
			list.add(i + " dkaldkalkd;a");
			bookmarkList.add(list);
		}		
		*/
		bm = new BookmarkManager(this);
		//List<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();
		//TableLayout bookmarkTable;
		
		/*
		bm.toggleBookmark(5);
		bm.toggleBookmark(30);
		bm.toggleBookmark(3);
		bm.toggleBookmark(7);
		bm.toggleBookmark(9);
		bm.toggleBookmark(10);
		bm.toggleBookmark(20);
		bm.toggleBookmark(60);
		bm.toggleBookmark(45);
		bm.toggleBookmark(13);
		bm.toggleBookmark(27);
		bm.toggleBookmark(34);
		bm.toggleBookmark(1);
		bm.toggleBookmark(4);
		bm.toggleBookmark(25);
		bm.toggleBookmark(18);
		bm.toggleBookmark(21);
		bm.toggleBookmark(12);
		bm.toggleBookmark(2);
		bm.toggleBookmark(44);
		*/
				
		bookmarkList = bm.viewBookmark();
		Log.d("Bookmark List Size", Integer.toString(bookmarkList.size()));
		
		bookmarkTable = (TableLayout) findViewById(R.id.bookmarkListTable);
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (int i=0;i<bookmarkList.size();i++){
			//TableRow tr = new TableRow(this);
			//tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
			View newRow = inflater.inflate(R.layout.bookmark_row, null);
			ImageView newImage = (ImageView) newRow.findViewById(R.id.plantImg);
			newImage.setImageResource(R.drawable.ic_launcher);
			Button newBtn = (Button) newRow.findViewById(R.id.plantName);
			newBtn.setText(bookmarkList.get(i).get(1));
			bookmarkTable.addView(newRow);
			
			newBtn.setOnClickListener(btnclick);
		}
		
	}
	
	Button.OnClickListener btnclick = new Button.OnClickListener(){

	    @Override
	    public void onClick(View v) {

	        Button btn = (Button)v;
	        //Toast.makeText(getApplicationContext(), button.getText().toString(),2).show(); 
	        MainActivity.plant = btn.getText().toString();
	        Intent intent = new Intent(getApplicationContext(), PlantInfo.class);  
			startActivity(intent);
	    }

	};
	
	public void onRestart() { 
	    super.onRestart();
	    //When BACK BUTTON is pressed, the activity on the stack is restarted
	    //Do what you want on the refresh procedure here
	    Log.d("TAG", "BookmarkList: onRestart()");
	    	    
	    bookmarkTable.removeAllViews();	
	    bookmarkList.clear();
	    
	    bookmarkList = bm.viewBookmark();
	    Log.d("Bookmark List Size", Integer.toString(bookmarkList.size()));
	    
	    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (int i=0;i<bookmarkList.size();i++){
			View newRow = inflater.inflate(R.layout.bookmark_row, null);
			ImageView newImage = (ImageView) newRow.findViewById(R.id.plantImg);
			newImage.setImageResource(R.drawable.ic_launcher);
			Button newBtn = (Button) newRow.findViewById(R.id.plantName);
			newBtn.setText(bookmarkList.get(i).get(1));
			bookmarkTable.addView(newRow);
			
			newBtn.setOnClickListener(btnclick);
		}
	}
}
