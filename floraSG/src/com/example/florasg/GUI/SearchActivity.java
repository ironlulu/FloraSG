package com.example.florasg.GUI;

import com.example.florasg.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

public class SearchActivity extends Activity {
	
	private TableLayout charTableScrollView;
	
	Button habitButton ;
	Button leafButton ;
	Button flowerButton ;
	Button fruitButton ;
	Button otherButton ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		charTableScrollView = (TableLayout) findViewById(R.id.charTableScrollView);
		
		habitButton = (Button) findViewById(R.id.habitButton);
		leafButton = (Button) findViewById(R.id.leafButton);
		flowerButton = (Button) findViewById(R.id.flowerButton);
		fruitButton = (Button) findViewById(R.id.fruitButton);
		otherButton = (Button) findViewById(R.id.otherButton);
		
		habitButton.setOnClickListener(habitButtonListener);
		leafButton.setOnClickListener(leafButtonListener);
		flowerButton.setOnClickListener(flowerButtonListener);
		fruitButton.setOnClickListener(fruitButtonListener);
		otherButton.setOnClickListener(otherButtonListener);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	public OnClickListener habitButtonListener = new OnClickListener(){

		@SuppressWarnings("null")
		@Override
		public void onClick(View arg0) {
			charTableScrollView.removeAllViews();

			// Get the LayoutInflator service
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			// Use the inflater to inflate a stock row from stock_quote_row.xml
			View newSubCategoryRow = inflater.inflate(R.layout.sub_category_row, null);
			
			TextView newSubCategoryTextView = (TextView) newSubCategoryRow.findViewById(R.id.subCategoryTextView);
			newSubCategoryTextView.setText(R.string.search_subcategory_habit);			

			
			LinearLayout newSubCategoryImageScrollView = (LinearLayout) newSubCategoryRow.findViewById(R.id.subCategoryImageScrollView);
			
			View newSubCategoryIcon = inflater.inflate(R.layout.sub_category_icon, null);
			ImageView newSubCategoryIconImageView = (ImageView) newSubCategoryIcon.findViewById(R.id.subCategoryIconImageView);
			newSubCategoryIconImageView.setImageResource(R.drawable.habit_habit_aquatic);			
			CheckBox newSubCategoryIconCheckBox = (CheckBox)newSubCategoryIcon.findViewById(R.id.subCategoryIconCheckBox);
			newSubCategoryIconCheckBox.setText(R.string.habit_habit_aquatic);
			newSubCategoryImageScrollView.addView(newSubCategoryIcon);
			
			newSubCategoryIcon = inflater.inflate(R.layout.sub_category_icon, null);
			newSubCategoryIconImageView = (ImageView) newSubCategoryIcon.findViewById(R.id.subCategoryIconImageView);
			newSubCategoryIconImageView.setImageResource(R.drawable.habit_habit_climber);			
			newSubCategoryIconCheckBox = (CheckBox)newSubCategoryIcon.findViewById(R.id.subCategoryIconCheckBox);
			newSubCategoryIconCheckBox.setText(R.string.habit_habit_climber);	
			newSubCategoryImageScrollView.addView(newSubCategoryIcon);
			
			newSubCategoryIcon = inflater.inflate(R.layout.sub_category_icon, null);
			newSubCategoryIconImageView = (ImageView) newSubCategoryIcon.findViewById(R.id.subCategoryIconImageView);
			newSubCategoryIconImageView.setImageResource(R.drawable.habit_habit_epiphyte);			
			newSubCategoryIconCheckBox = (CheckBox)newSubCategoryIcon.findViewById(R.id.subCategoryIconCheckBox);
			newSubCategoryIconCheckBox.setText(R.string.habit_habit_epiphyte);	
			newSubCategoryImageScrollView.addView(newSubCategoryIcon);
			
			
			newSubCategoryIcon = inflater.inflate(R.layout.sub_category_icon, null);
			newSubCategoryIconImageView = (ImageView) newSubCategoryIcon.findViewById(R.id.subCategoryIconImageView);
			newSubCategoryIconImageView.setImageResource(R.drawable.habit_habit_herb);			
			newSubCategoryIconCheckBox = (CheckBox)newSubCategoryIcon.findViewById(R.id.subCategoryIconCheckBox);
			newSubCategoryIconCheckBox.setText(R.string.habit_habit_herb);	
			newSubCategoryImageScrollView.addView(newSubCategoryIcon);
			
			
			newSubCategoryIcon = inflater.inflate(R.layout.sub_category_icon, null);
			newSubCategoryIconImageView = (ImageView) newSubCategoryIcon.findViewById(R.id.subCategoryIconImageView);
			newSubCategoryIconImageView.setImageResource(R.drawable.habit_habit_shrub);			
			newSubCategoryIconCheckBox = (CheckBox)newSubCategoryIcon.findViewById(R.id.subCategoryIconCheckBox);
			newSubCategoryIconCheckBox.setText(R.string.habit_habit_shrub);	
			newSubCategoryImageScrollView.addView(newSubCategoryIcon);
			
			newSubCategoryIcon = inflater.inflate(R.layout.sub_category_icon, null);
			newSubCategoryIconImageView = (ImageView) newSubCategoryIcon.findViewById(R.id.subCategoryIconImageView);
			newSubCategoryIconImageView.setImageResource(R.drawable.habit_habit_tree);			
			newSubCategoryIconCheckBox = (CheckBox)newSubCategoryIcon.findViewById(R.id.subCategoryIconCheckBox);
			newSubCategoryIconCheckBox.setText(R.string.habit_habit_tree);	
			newSubCategoryImageScrollView.addView(newSubCategoryIcon);
			
			charTableScrollView.addView(newSubCategoryRow);
		}
	
	};
	
	public OnClickListener leafButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			charTableScrollView.removeAllViews();
			
		}
		
	};
	
	public OnClickListener flowerButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			charTableScrollView.removeAllViews();
			
		}
		
	};
	
	public OnClickListener fruitButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			charTableScrollView.removeAllViews();
			
		}
	
	};
	
	public OnClickListener otherButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			charTableScrollView.removeAllViews();
			
		}
		
	};





}
