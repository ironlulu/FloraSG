package com.example.florasg.GUI;

import com.example.florasg.MainActivity;
import com.example.florasg.R;
import com.example.florasg.Controller.BookmarkManager;
import com.example.florasg.Controller.PlantDataRetriever;
import com.example.florasg.Model.Plant;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlantInfo extends Activity {
	
	private TableLayout infoTable;
	private Plant plantObj;
	PlantDataRetriever PDR;
	BookmarkManager bm;
	private String bookmarkStatus;
	public boolean isBookmark;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plant_info);
		setTitle(MainActivity.plant);
				
		/*
		for (int i=0;i<20;i++){
			ImageView newImage = new ImageView(this);
			newImage.setImageResource(R.drawable.ic_launcher);
			infoTable.addView(newImage);
		}
		*/
		
		// Open plantDatabase and get plantObj
		PDR = new PlantDataRetriever(this);
		PDR.openDB();
		plantObj = PDR.getPlant(MainActivity.plant);
		View newRow;
		TextView newTitle;
		TextView newContent;
		
		// Open bookmarkManage and ready to add bookmark
		bm = new BookmarkManager(this);
		
		// Check for bookmarkStatus
		bookmarkStatus = plantObj.getBookmarkStatus();
		
		if (bookmarkStatus.equalsIgnoreCase("true")) {
	        isBookmark = true;
	    } else {
	    	isBookmark = false;
	    }
		

		// Display pictures
		LinearLayout imgRow = (LinearLayout) findViewById(R.id.imageListScrollView);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.setMargins(24, 20, 24, 10);
		for (int i=0;i<10;i++){
			ImageView newImage = new ImageView(this);
			newImage.setImageResource(R.drawable.acraur_leaf);
			imgRow.addView(newImage,params);
		}
		
		
		// Display detailed information
		infoTable = (TableLayout) findViewById(R.id.plantInfoTable);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		// Scientific name
		if (plantObj.getSciName()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Scientific Name");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getSciName());
		infoTable.addView(newRow);
		}
		
		// Common name
		if (plantObj.getComName()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Common Name");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getComName());
		infoTable.addView(newRow);
		}
		
		// Family 
		if (plantObj.getFamily()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Family");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getFamily());
		infoTable.addView(newRow);
		}
		
		// Description
		if (plantObj.getDescription()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Description");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getDescription());
		infoTable.addView(newRow);
		}
		
		// Habitat
		if (plantObj.getHabitat()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Habitat");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getHabitat());
		infoTable.addView(newRow);
		}
		
		// Leaf size
		if (plantObj.getMinLeafSize() != 0 && plantObj.getMaxLeafSize()!= 0){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Leaf size");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText("Min Leaf size: " + plantObj.getMinLeafSize() + "\n" + "Max Leaf size: "
		+ plantObj.getMaxLeafSize());
		infoTable.addView(newRow);
		}
		
		// distribution
		if (plantObj.getDistribution()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Distribution");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getDistribution());
		infoTable.addView(newRow);
		}
		
		// conservationStatus
		if (plantObj.getConservationStatus()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Conservation Status");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getConservationStatus());
		infoTable.addView(newRow);
		}
		
		// growthReq
		if (plantObj.getGrowthReq()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Growth Requirements");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getGrowthReq());
		infoTable.addView(newRow);
		}
		
		// horticulturalFeatures
		if (plantObj.getHorticulturalFeatures()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Horticultural Features");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getHorticulturalFeatures());
		infoTable.addView(newRow);
		}
		
		// uses
		if (plantObj.getUses()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Uses");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getUses());
		infoTable.addView(newRow);
		}
		
		// associatedFauna
		if (plantObj.getAssociatedFauna()!= null){
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Associated Fauna");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getAssociatedFauna());
		infoTable.addView(newRow);
		}
						
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plant_info, menu);
		return true;
	}
	
	public boolean onPrepareOptionsMenu(Menu menu) {
	    MenuItem fave = menu.findItem(R.id.add);
	    MenuItem unfave = menu.findItem(R.id.remove);

	    fave.setVisible(!isBookmark);
	    unfave.setVisible(isBookmark);

	    return true;
	}
	
	@SuppressLint("NewApi")
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.add:
	    	isBookmark = true;
	        //bm.toggleBookmark(MainActivity.plant)
	        invalidateOptionsMenu();
	        Toast.makeText(getApplicationContext(), 
                    "Add to Bookmark List!", Toast.LENGTH_SHORT).show();
	        //Toast("Removed from Favourites");
	        return true;
	    case R.id.remove:
	        isBookmark = false;
	        //bm.toggleBookmark(MainActivity.plant)
	        invalidateOptionsMenu();
	        Toast.makeText(getApplicationContext(), 
                    "Deleted from Bookmark List!", Toast.LENGTH_SHORT).show();
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

}
