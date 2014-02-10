package com.example.florasg.GUI.searchGUI;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.florasg.R;
import com.example.florasg.GUI.TabMainActivity;

/*

@SuppressWarnings("deprecation")
public class SearchActivity extends TabActivity implements OnTabChangeListener {
	
	public static String categoryName;
	public static ArrayList<String> categoryList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		categoryList = new ArrayList<String>();
		
		//Test data
		categoryList.add("Habit");
		categoryList.add("Leaf");
		categoryList.add("Flower");
		categoryList.add("Fruit");
		categoryList.add("Other");
		int size = categoryList.size();
		
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setOnTabChangedListener(this);
		
		for (int i=0;i<size;i++){
			String category = categoryList.get(i);
			Intent newIntent = new Intent().setClass(this, SelectCharActivity.class);
			TabSpec newSpec = tabHost
					  .newTabSpec(category)
					  .setIndicator(category)
					  .setContent(newIntent);
			tabHost.addTab(newSpec);
		}
		tabHost.setCurrentTab(0);
		categoryName = categoryList.get(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		Log.i("Tab id", ""+tabId);
        categoryName = tabId;
        //Log.i("Category Name", ""+categoryName);
	}


*/

public class SearchActivity extends Activity {
	
	public final static  String CHAR_LIST = "com.example.florasg.GUI.searchGUI.CHARLIST";

	private TableLayout charTableScrollView;
	
	Button habitButton ;
	Button leafButton ;
	Button flowerButton ;
	Button fruitButton ;
	Button otherButton ;
	Button clearButton;
	Button resultButton;
	
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
		
		clearButton = (Button) findViewById(R.id.clearButton);
		resultButton = (Button) findViewById(R.id.resultButton);
		
		
		clearButton.setOnClickListener(clearButtonListener);
		resultButton.setOnClickListener(resultButtonListener);
		

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
			
			//TODO
			//get subcategory list from database
			//getSubCategoryList();
			//update scrollview on GUI
			//updateScrollView();

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
	
	
	public OnClickListener clearButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			//TODO
			//clear all the characteristics checked
			
		}
		
	};
	
	
	public OnClickListener resultButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			
			ArrayList<String> charList = new ArrayList<String>();
			String c = "The checked sub cates are-->";
			charList.add(c);			
			int noSubCates = charTableScrollView.getChildCount();
			for(int i=0;i<noSubCates;i++){				
				View subCateRow = charTableScrollView.getChildAt(i);			
				LinearLayout subCateImgScrollView = (LinearLayout) subCateRow.findViewById(R.id.subCategoryImageScrollView);
				
				int noSubCateIcon = subCateImgScrollView.getChildCount();
				for(int j=0;j<noSubCateIcon;j++){
					View subCateIcon = subCateImgScrollView.getChildAt(j);
					CheckBox cb = (CheckBox) subCateIcon.findViewById(R.id.subCategoryIconCheckBox);
					if(cb.isChecked()){
						c = (String) cb.getText();
						charList.add(c);
					}
				}
				
			}
		
			
			Intent intent = new Intent(getBaseContext(), SearchResultActivity.class); 
			intent.putStringArrayListExtra(CHAR_LIST, charList);
			startActivity(intent);			
		}
		
	};

	
	
}






