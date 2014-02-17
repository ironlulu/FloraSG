package com.example.florasg.GUI.profileGUI;

import java.util.ArrayList;
import java.util.List;

import com.example.florasg.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class BookmarkActivity extends Activity {
	
	private TableLayout bookmarkTable;
	private List<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_bookmark);
				
		for (int i=0; i<10;i++){
			ArrayList<String> list = new ArrayList<String>();
			list.add("img"+i);
			list.add(i + " dkaldkalkd;a");
			bookmarkList.add(list);
		}		
		
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
		}
		
	}

}
