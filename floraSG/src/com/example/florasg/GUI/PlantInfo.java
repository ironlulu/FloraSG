package com.example.florasg.GUI;

import com.example.florasg.MainActivity;
import com.example.florasg.R;
import com.example.florasg.Controller.PlantDataRetriever;
import com.example.florasg.Model.Plant;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class PlantInfo extends Activity {
	
	private TableLayout infoTable;
	private Plant plantObj;
	PlantDataRetriever PDR;

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
		PDR = new PlantDataRetriever(this);
		PDR.openDB();
		plantObj = PDR.getPlant(MainActivity.plant);
		
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
		View newRow = inflater.inflate(R.layout.plant_info_row, null);
		TextView newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Scientific Name");
		TextView newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getSciName());
		infoTable.addView(newRow);
		
		// Common name
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Common Name");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getComName());
		infoTable.addView(newRow);
		
		// Family 
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Family");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getFamily());
		infoTable.addView(newRow);
		
		// Description
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Description");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getDescription());
		infoTable.addView(newRow);
		
		// Habitat
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Habitat");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getHabitat());
		infoTable.addView(newRow);
		
		// Leaf size
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Leaf size");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText("Min Leaf size: " + plantObj.getMinLeafSize() + "\n" + "Max Leaf size: "
		+ plantObj.getMaxLeafSize());
		infoTable.addView(newRow);
		
		// distribution
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Distribution");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getDistribution());
		infoTable.addView(newRow);
		
		// conservationStatus
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Conservation Status");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getConservationStatus());
		infoTable.addView(newRow);
		
		// growthReq
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Growth Requirements");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getGrowthReq());
		infoTable.addView(newRow);
		
		// horticulturalFeatures
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Horticultural Features");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getHorticulturalFeatures());
		infoTable.addView(newRow);
		
		// uses
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Uses");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getUses());
		infoTable.addView(newRow);
		
		// associatedFauna
		newRow = inflater.inflate(R.layout.plant_info_row, null);
		newTitle = (TextView)newRow.findViewById(R.id.title);
		newTitle.setText("Associated Fauna");
		newContent = (TextView)newRow.findViewById(R.id.content);
		newContent.setText(plantObj.getAssociatedFauna());
		infoTable.addView(newRow);
						
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plant_info, menu);
		return true;
	}

}
