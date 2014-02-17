package com.example.florasg.GUI.searchGUI;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.florasg.R;

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

	public final static  String DESC_LIST = "com.example.florasg.GUI.searchGUI.DESC_LIST";
	private static final int       CATE_HABIT = 0;
	private static final int       CATE_LEAF = 1;
	private static final int       CATE_FLOWER = 2;
	private static final int       CATE_FRUIT = 3;
	private static final int       CATE_OTHER = 4;

	private static final String    CATE_HABIT_STRING = "Habit";
	private static final String       CATE_LEAF_STRING = "Leaf";
	private static final String       CATE_FLOWER_STRING = "Flower";
	private static final String       CATE_FRUIT_STRING = "Fruit";
	private static final String       CATE_OTHER_STRING = "Other";

	private LinearLayout categoryScrollView;
	private TableLayout descTableScrollView;
	private List<String> categoryList = new ArrayList<String>();
	private List<String> subCateList =  new ArrayList<String>();
	private ArrayList<Integer> descIdList =  new ArrayList<Integer>();


	//SearchElementRetriever ser = new SearchElementRetriever();

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

		categoryScrollView = (LinearLayout)findViewById(R.id.categoryListScrollView);
		descTableScrollView = (TableLayout) findViewById(R.id.subCateTableScrollView);

		descIdList =  new ArrayList<Integer>();
		//categoryList = ser.getCategory();
		categoryList.add("Habit");
		categoryList.add("Leaf");
		categoryList.add("Flower");
		categoryList.add("Fruit");
		categoryList.add("Other");
		categoryList.add("blalala");
		categoryList.add("blalala");
		categoryList.add("blalala");


		int cateNum = categoryList.size();
		for (int i = 0; i < cateNum; i++) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			Button btn = new Button(this);
			btn.setId(i);
			final int id_ = btn.getId();
			String cate = categoryList.get(i);
			btn.setText(cate);
			categoryScrollView.addView(btn);
			Button btn1 = ((Button) findViewById(id_));


			int cateId = 0;
			if(cate == "Habit")
				cateId = CATE_HABIT;
			else if(cate == "Leaf")
				cateId = CATE_LEAF;
			else if(cate == "Flower")
				cateId = CATE_FLOWER;
			else if(cate == "Fruit")
				cateId = CATE_FRUIT;
			else if(cate == "Other")
				cateId = CATE_OTHER;


			switch(cateId){
			case CATE_HABIT:
				btn1.setOnClickListener(habitButtonListener);
				break;
			case CATE_LEAF:
				btn1.setOnClickListener(leafButtonListener);
				break;
			case CATE_FLOWER:
				btn1.setOnClickListener(flowerButtonListener);
				break;
			case CATE_FRUIT:
				btn1.setOnClickListener(fruitButtonListener);
				break;
			case CATE_OTHER:
				btn1.setOnClickListener(otherButtonListener);
				break;
			}

		}

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
	
	
	protected void onResume(Bundle savedInstanceState){
		super.onResume();
		descIdList =  new ArrayList<Integer>();

	}

	public OnClickListener habitButtonListener = new OnClickListener(){

		@SuppressWarnings("null")
		@Override
		public void onClick(View arg0) {
			descTableScrollView.removeAllViews();			
			updateSubCategoryView(CATE_HABIT_STRING);
		}

	};

	public OnClickListener leafButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			descTableScrollView.removeAllViews();

		}

	};

	public OnClickListener flowerButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			descTableScrollView.removeAllViews();

		}

	};

	public OnClickListener fruitButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			descTableScrollView.removeAllViews();

		}

	};

	public OnClickListener otherButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			descTableScrollView.removeAllViews();

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

			Intent intent = new Intent(getBaseContext(), SearchResultActivity.class); 
			intent.putIntegerArrayListExtra(DESC_LIST, descIdList);
			startActivity(intent);			
		}

	};
	
	private void updateSubCategoryView(String cateString){
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//subCateList = ser.getSubCategory(cateString);
		subCateList.add("Habit");
		subCateList.add("Habit sub2");
		subCateList.add("Habit sub3");

		int subCateNum = subCateList.size();
		View newSubCategoryRow = null;
		List<String[]> descList = new ArrayList<String[]>();

		for(int i=0;i<subCateNum;i++){
			newSubCategoryRow = inflater.inflate(R.layout.sub_category_row, null);
			TextView newSubCategoryTextView = (TextView) newSubCategoryRow.findViewById(R.id.subCategoryTextView);
			newSubCategoryTextView.setText(subCateList.get(i));
			LinearLayout newdescImageScrollView = (LinearLayout) newSubCategoryRow.findViewById(R.id.descImageScrollView);
			
			newdescImageScrollView.removeAllViews();
			descList.clear();
			
			//descList = ser.getdescacteristics(subCateList.get(i));
			String[] characteristic1 = new String[3];
			characteristic1[0] = Integer.toString(i*10+1);
			characteristic1[1] = "aquatic";
			characteristic1[2] = "habit_habit_aquatic";
			descList.add(characteristic1);
			String[] characteristic2 = new String[3];
			characteristic2[0] = Integer.toString(i*10+2);
			characteristic2[1] = "climber";
			characteristic2[2] = "habit_habit_climber";
			descList.add(characteristic2);
			String[] characteristic3 = new String[3];
			characteristic3[0] = Integer.toString(i*10+3);
			characteristic3[1] = "epiphyte";
			characteristic3[2] = "habit_habit_epiphyte";
			descList.add(characteristic3);
			String[] characteristic4 = new String[3];
			characteristic4[0] = Integer.toString(i*10+4);
			characteristic4[1] = "herb";
			characteristic4[2] = "habit_habit_herb";
			descList.add(characteristic4);
			String[] characteristic5 = new String[3];
			characteristic5[0] = Integer.toString(i*10+5);
			characteristic5[1] = "shrub";
			characteristic5[2] = "habit_habit_shrub";
			descList.add(characteristic5);
			String[] characteristic6 = new String[3];
			characteristic6[0] = Integer.toString(i*10+6);
			characteristic6[1] = "tree";
			characteristic6[2] = "habit_habit_tree";
			descList.add(characteristic6);
	

			int descNum = descList.size();
			for(int j=0;j<descNum;j++){
				int descId = Integer.parseInt(descList.get(j)[0]);
				String descName = descList.get(j)[1];
				String descImgName = descList.get(j)[2];
				View newdescIcon = inflater.inflate(R.layout.sub_category_icon, null);
				
				ImageView newdescIconImageView = (ImageView) newdescIcon.findViewById(R.id.descIconImageView);
				int resID = getResources().getIdentifier(descImgName, "drawable", getPackageName());
				newdescIconImageView.setImageResource(resID);			
				
				CheckBox newdescIconCheckBox = (CheckBox)newdescIcon.findViewById(R.id.descIconCheckBox);
				newdescIconCheckBox.setText(descName);
				//newdescIconCheckBox.setId(descId);
				
				newdescIconCheckBox.setTag(descId);
				newdescIconCheckBox.setOnCheckedChangeListener(checkBoxListener);
				newdescImageScrollView.addView(newdescIcon);
			}
			
			
			descTableScrollView.addView(newSubCategoryRow);

		}


	
	}
	
	public OnCheckedChangeListener checkBoxListener = new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if(isChecked){
				int c = (Integer)buttonView.getTag();
				descIdList.add(c);
			}
			else{
				descIdList.remove(buttonView.getTag());

		}
			
		}
		
	};



}





